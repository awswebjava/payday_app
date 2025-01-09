package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvediahoras extends GXProcedure
{
   public getconvediahoras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvediahoras.class ), "" );
   }

   public getconvediahoras( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           short aP3 ,
                                           String aP4 ,
                                           String aP5 )
   {
      getconvediahoras.this.aP6 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 )
   {
      getconvediahoras.this.AV15CliCod = aP0;
      getconvediahoras.this.AV17EmpCod = aP1;
      getconvediahoras.this.AV16LegNumero = aP2;
      getconvediahoras.this.AV8PaiCod = aP3;
      getconvediahoras.this.AV9ConveCodigo = aP4;
      getconvediahoras.this.AV11parmPaiTipoTraId = aP5;
      getconvediahoras.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV14CliConveVer ;
      new web.getversiondelegajo(remoteHandle, context).execute( AV15CliCod, AV17EmpCod, AV16LegNumero, GXv_int1) ;
      getconvediahoras.this.AV14CliConveVer = GXv_int1[0] ;
      /* Using cursor P01B12 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliConveVer), Short.valueOf(AV8PaiCod), AV9ConveCodigo, AV11parmPaiTipoTraId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1294PaiTipoTraId = P01B12_A1294PaiTipoTraId[0] ;
         A1565CliConvenio = P01B12_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01B12_A1564CliPaiConve[0] ;
         A3CliCod = P01B12_A3CliCod[0] ;
         A1323ConveHsDia = P01B12_A1323ConveHsDia[0] ;
         AV13ConveHsDia = A1323ConveHsDia ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getconvediahoras.this.AV13ConveHsDia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ConveHsDia = DecimalUtil.ZERO ;
      GXv_int1 = new int[1] ;
      scmdbuf = "" ;
      P01B12_A1294PaiTipoTraId = new String[] {""} ;
      P01B12_A1565CliConvenio = new String[] {""} ;
      P01B12_A1564CliPaiConve = new short[1] ;
      P01B12_A3CliCod = new int[1] ;
      P01B12_A1323ConveHsDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1294PaiTipoTraId = "" ;
      A1565CliConvenio = "" ;
      A1323ConveHsDia = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvediahoras__default(),
         new Object[] {
             new Object[] {
            P01B12_A1294PaiTipoTraId, P01B12_A1565CliConvenio, P01B12_A1564CliPaiConve, P01B12_A3CliCod, P01B12_A1323ConveHsDia
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17EmpCod ;
   private short AV8PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV16LegNumero ;
   private int AV14CliConveVer ;
   private int GXv_int1[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV13ConveHsDia ;
   private java.math.BigDecimal A1323ConveHsDia ;
   private String AV9ConveCodigo ;
   private String AV11parmPaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String A1565CliConvenio ;
   private java.math.BigDecimal[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P01B12_A1294PaiTipoTraId ;
   private String[] P01B12_A1565CliConvenio ;
   private short[] P01B12_A1564CliPaiConve ;
   private int[] P01B12_A3CliCod ;
   private java.math.BigDecimal[] P01B12_A1323ConveHsDia ;
}

final  class getconvediahoras__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01B12", "SELECT PaiTipoTraId, CliConvenio, CliPaiConve, CliCod, ConveHsDia FROM convenio_tiposdetrabajo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and PaiTipoTraId = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,1);
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
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

