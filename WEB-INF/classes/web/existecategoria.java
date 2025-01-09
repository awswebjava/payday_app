package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class existecategoria extends GXProcedure
{
   public existecategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( existecategoria.class ), "" );
   }

   public existecategoria( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 )
   {
      existecategoria.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      existecategoria.this.AV8CliCod = aP0;
      existecategoria.this.AV9CliPaiConve = aP1;
      existecategoria.this.AV10CatCodigo = aP2;
      existecategoria.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P020B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9CliPaiConve), AV10CatCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A8CatCodigo = P020B2_A8CatCodigo[0] ;
         A1564CliPaiConve = P020B2_A1564CliPaiConve[0] ;
         A3CliCod = P020B2_A3CliCod[0] ;
         A1565CliConvenio = P020B2_A1565CliConvenio[0] ;
         AV11existe = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = existecategoria.this.AV11existe;
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
      P020B2_A8CatCodigo = new String[] {""} ;
      P020B2_A1564CliPaiConve = new short[1] ;
      P020B2_A3CliCod = new int[1] ;
      P020B2_A1565CliConvenio = new String[] {""} ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.existecategoria__default(),
         new Object[] {
             new Object[] {
            P020B2_A8CatCodigo, P020B2_A1564CliPaiConve, P020B2_A3CliCod, P020B2_A1565CliConvenio
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
   private String AV10CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private boolean AV11existe ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P020B2_A8CatCodigo ;
   private short[] P020B2_A1564CliPaiConve ;
   private int[] P020B2_A3CliCod ;
   private String[] P020B2_A1565CliConvenio ;
}

final  class existecategoria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020B2", "SELECT CatCodigo, CliPaiConve, CliCod, CliConvenio FROM Categoria1 WHERE (CliCod = ? and CliPaiConve = ?) AND (CatCodigo = ( ?)) ORDER BY CliCod, CliPaiConve ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
               stmt.setString(3, (String)parms[2], 40);
               return;
      }
   }

}

