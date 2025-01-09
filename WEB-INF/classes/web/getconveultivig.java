package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconveultivig extends GXProcedure
{
   public getconveultivig( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconveultivig.class ), "" );
   }

   public getconveultivig( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           String aP2 ,
                           java.util.Date aP3 ,
                           java.util.Date[] aP4 )
   {
      getconveultivig.this.aP5 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date[] aP4 ,
                        byte[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date[] aP4 ,
                             byte[] aP5 )
   {
      getconveultivig.this.AV11CliCod = aP0;
      getconveultivig.this.AV10CliPaiConve = aP1;
      getconveultivig.this.AV9CliConvenio = aP2;
      getconveultivig.this.AV14parmCatVigencia = aP3;
      getconveultivig.this.aP4 = aP4;
      getconveultivig.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01TM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10CliPaiConve), AV9CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1565CliConvenio = P01TM2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01TM2_A1564CliPaiConve[0] ;
         A3CliCod = P01TM2_A3CliCod[0] ;
         A8CatCodigo = P01TM2_A8CatCodigo[0] ;
         AV8CatCodigo = A8CatCodigo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14parmCatVigencia)) )
      {
         AV15parmCatVigencia_comienzo = localUtil.ymdtod( GXutil.year( AV14parmCatVigencia), GXutil.month( AV14parmCatVigencia), 1) ;
      }
      GXv_date1[0] = AV12CatVigencia ;
      GXv_int2[0] = AV13CatFrecAct ;
      new web.getcatultivig(remoteHandle, context).execute( AV11CliCod, AV10CliPaiConve, AV9CliConvenio, AV8CatCodigo, AV14parmCatVigencia, AV15parmCatVigencia_comienzo, GXv_date1, GXv_int2) ;
      getconveultivig.this.AV12CatVigencia = GXv_date1[0] ;
      getconveultivig.this.AV13CatFrecAct = GXv_int2[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getconveultivig.this.AV12CatVigencia;
      this.aP5[0] = getconveultivig.this.AV13CatFrecAct;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12CatVigencia = GXutil.nullDate() ;
      scmdbuf = "" ;
      P01TM2_A1565CliConvenio = new String[] {""} ;
      P01TM2_A1564CliPaiConve = new short[1] ;
      P01TM2_A3CliCod = new int[1] ;
      P01TM2_A8CatCodigo = new String[] {""} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      AV8CatCodigo = "" ;
      AV15parmCatVigencia_comienzo = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      GXv_int2 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconveultivig__default(),
         new Object[] {
             new Object[] {
            P01TM2_A1565CliConvenio, P01TM2_A1564CliPaiConve, P01TM2_A3CliCod, P01TM2_A8CatCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13CatFrecAct ;
   private byte GXv_int2[] ;
   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int A3CliCod ;
   private String AV9CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV8CatCodigo ;
   private java.util.Date AV14parmCatVigencia ;
   private java.util.Date AV12CatVigencia ;
   private java.util.Date AV15parmCatVigencia_comienzo ;
   private java.util.Date GXv_date1[] ;
   private byte[] aP5 ;
   private java.util.Date[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01TM2_A1565CliConvenio ;
   private short[] P01TM2_A1564CliPaiConve ;
   private int[] P01TM2_A3CliCod ;
   private String[] P01TM2_A8CatCodigo ;
}

final  class getconveultivig__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01TM2", "SELECT CliConvenio, CliPaiConve, CliCod, CatCodigo FROM Categoria1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
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
               return;
      }
   }

}

