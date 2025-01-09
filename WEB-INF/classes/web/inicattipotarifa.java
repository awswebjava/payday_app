package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicattipotarifa extends GXProcedure
{
   public inicattipotarifa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicattipotarifa.class ), "" );
   }

   public inicattipotarifa( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LH2 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1838CatClase = P02LH2_A1838CatClase[0] ;
         A2416CatTipoTarifa = P02LH2_A2416CatTipoTarifa[0] ;
         A3CliCod = P02LH2_A3CliCod[0] ;
         A1564CliPaiConve = P02LH2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02LH2_A1565CliConvenio[0] ;
         A8CatCodigo = P02LH2_A8CatCodigo[0] ;
         if ( A1838CatClase == 1 )
         {
            A2416CatTipoTarifa = "P" ;
         }
         else
         {
            A2416CatTipoTarifa = "H" ;
         }
         /* Using cursor P02LH3 */
         pr_default.execute(1, new Object[] {A2416CatTipoTarifa, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicattipotarifa");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02LH2_A1838CatClase = new byte[1] ;
      P02LH2_A2416CatTipoTarifa = new String[] {""} ;
      P02LH2_A3CliCod = new int[1] ;
      P02LH2_A1564CliPaiConve = new short[1] ;
      P02LH2_A1565CliConvenio = new String[] {""} ;
      P02LH2_A8CatCodigo = new String[] {""} ;
      A2416CatTipoTarifa = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicattipotarifa__default(),
         new Object[] {
             new Object[] {
            P02LH2_A1838CatClase, P02LH2_A2416CatTipoTarifa, P02LH2_A3CliCod, P02LH2_A1564CliPaiConve, P02LH2_A1565CliConvenio, P02LH2_A8CatCodigo
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1838CatClase ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String A2416CatTipoTarifa ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private IDataStoreProvider pr_default ;
   private byte[] P02LH2_A1838CatClase ;
   private String[] P02LH2_A2416CatTipoTarifa ;
   private int[] P02LH2_A3CliCod ;
   private short[] P02LH2_A1564CliPaiConve ;
   private String[] P02LH2_A1565CliConvenio ;
   private String[] P02LH2_A8CatCodigo ;
}

final  class inicattipotarifa__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LH2", "SELECT CatClase, CatTipoTarifa, CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo  FOR UPDATE OF Categoria1",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02LH3", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatTipoTarifa=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 1);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               stmt.setString(1, (String)parms[0], 1);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 40);
               return;
      }
   }

}

