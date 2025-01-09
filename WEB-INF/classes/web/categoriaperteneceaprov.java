package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class categoriaperteneceaprov extends GXProcedure
{
   public categoriaperteneceaprov( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoriaperteneceaprov.class ), "" );
   }

   public categoriaperteneceaprov( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              String aP3 ,
                              short aP4 )
   {
      categoriaperteneceaprov.this.aP5 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        short aP4 ,
                        boolean[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             boolean[] aP5 )
   {
      categoriaperteneceaprov.this.AV8CliCod = aP0;
      categoriaperteneceaprov.this.AV9CliPaiConve = aP1;
      categoriaperteneceaprov.this.AV10CliConvenio = aP2;
      categoriaperteneceaprov.this.AV11CatCodigo = aP3;
      categoriaperteneceaprov.this.AV13CatProvCod = aP4;
      categoriaperteneceaprov.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18GXLvl1 = (byte)(0) ;
      /* Using cursor P026B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9CliPaiConve), AV10CliConvenio, AV11CatCodigo, Short.valueOf(AV9CliPaiConve), Short.valueOf(AV13CatProvCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2201CatProvCod = P026B2_A2201CatProvCod[0] ;
         A2200CatPaiCod = P026B2_A2200CatPaiCod[0] ;
         A8CatCodigo = P026B2_A8CatCodigo[0] ;
         A1565CliConvenio = P026B2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P026B2_A1564CliPaiConve[0] ;
         A3CliCod = P026B2_A3CliCod[0] ;
         AV18GXLvl1 = (byte)(1) ;
         AV14pertenece = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV18GXLvl1 == 0 )
      {
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = categoriaperteneceaprov.this.AV14pertenece;
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
      P026B2_A2201CatProvCod = new short[1] ;
      P026B2_A2200CatPaiCod = new short[1] ;
      P026B2_A8CatCodigo = new String[] {""} ;
      P026B2_A1565CliConvenio = new String[] {""} ;
      P026B2_A1564CliPaiConve = new short[1] ;
      P026B2_A3CliCod = new int[1] ;
      A8CatCodigo = "" ;
      A1565CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoriaperteneceaprov__default(),
         new Object[] {
             new Object[] {
            P026B2_A2201CatProvCod, P026B2_A2200CatPaiCod, P026B2_A8CatCodigo, P026B2_A1565CliConvenio, P026B2_A1564CliPaiConve, P026B2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl1 ;
   private short AV9CliPaiConve ;
   private short AV13CatProvCod ;
   private short A2201CatProvCod ;
   private short A2200CatPaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV11CatCodigo ;
   private String scmdbuf ;
   private String A8CatCodigo ;
   private String A1565CliConvenio ;
   private boolean AV14pertenece ;
   private boolean[] aP5 ;
   private IDataStoreProvider pr_default ;
   private short[] P026B2_A2201CatProvCod ;
   private short[] P026B2_A2200CatPaiCod ;
   private String[] P026B2_A8CatCodigo ;
   private String[] P026B2_A1565CliConvenio ;
   private short[] P026B2_A1564CliPaiConve ;
   private int[] P026B2_A3CliCod ;
}

final  class categoriaperteneceaprov__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P026B2", "SELECT CatProvCod, CatPaiCod, CatCodigo, CliConvenio, CliPaiConve, CliCod FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatPaiCod = ? and CatProvCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
      }
   }

}

