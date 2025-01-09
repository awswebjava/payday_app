package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipotarifacat extends GXProcedure
{
   public gettipotarifacat( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipotarifacat.class ), "" );
   }

   public gettipotarifacat( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 )
   {
      gettipotarifacat.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      gettipotarifacat.this.AV8CliCod = aP0;
      gettipotarifacat.this.AV9CliPaiConve = aP1;
      gettipotarifacat.this.AV12CliConvenio = aP2;
      gettipotarifacat.this.AV11CatCodigo = aP3;
      gettipotarifacat.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02LG2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9CliPaiConve), AV12CliConvenio, AV11CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P02LG2_A8CatCodigo[0] ;
         A1565CliConvenio = P02LG2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P02LG2_A1564CliPaiConve[0] ;
         A3CliCod = P02LG2_A3CliCod[0] ;
         A2416CatTipoTarifa = P02LG2_A2416CatTipoTarifa[0] ;
         AV13CatTipoTarifa = A2416CatTipoTarifa ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gettipotarifacat.this.AV13CatTipoTarifa;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13CatTipoTarifa = "" ;
      scmdbuf = "" ;
      P02LG2_A8CatCodigo = new String[] {""} ;
      P02LG2_A1565CliConvenio = new String[] {""} ;
      P02LG2_A1564CliPaiConve = new short[1] ;
      P02LG2_A3CliCod = new int[1] ;
      P02LG2_A2416CatTipoTarifa = new String[] {""} ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      A2416CatTipoTarifa = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.gettipotarifacat__default(),
         new Object[] {
             new Object[] {
            P02LG2_A8CatCodigo, P02LG2_A1565CliConvenio, P02LG2_A1564CliPaiConve, P02LG2_A3CliCod, P02LG2_A2416CatTipoTarifa
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV12CliConvenio ;
   private String AV11CatCodigo ;
   private String AV13CatTipoTarifa ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private String A2416CatTipoTarifa ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P02LG2_A8CatCodigo ;
   private String[] P02LG2_A1565CliConvenio ;
   private short[] P02LG2_A1564CliPaiConve ;
   private int[] P02LG2_A3CliCod ;
   private String[] P02LG2_A2416CatTipoTarifa ;
}

final  class gettipotarifacat__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LG2", "SELECT CatCodigo, CliConvenio, CliPaiConve, CliCod, CatTipoTarifa FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
   }

}

