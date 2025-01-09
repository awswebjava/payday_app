package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getapliiggtope extends GXProcedure
{
   public getapliiggtope( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getapliiggtope.class ), "" );
   }

   public getapliiggtope( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             byte[] aP14 )
   {
      getapliiggtope.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        byte[] aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             byte[] aP14 ,
                             String[] aP15 )
   {
      getapliiggtope.this.AV10CliCod = aP0;
      getapliiggtope.this.AV20EmpCod = aP1;
      getapliiggtope.this.AV16LiqNro = aP2;
      getapliiggtope.this.AV17LegNumero = aP3;
      getapliiggtope.this.AV14LiqPeriodo = aP4;
      getapliiggtope.this.AV8AplIIGG = aP5;
      getapliiggtope.this.AV24ProcesoLiquidacion = aP6;
      getapliiggtope.this.AV25insertandoConceptos = aP7;
      getapliiggtope.this.aP8 = aP8;
      getapliiggtope.this.aP9 = aP9;
      getapliiggtope.this.aP10 = aP10;
      getapliiggtope.this.aP11 = aP11;
      getapliiggtope.this.aP12 = aP12;
      getapliiggtope.this.aP13 = aP13;
      getapliiggtope.this.aP14 = aP14;
      getapliiggtope.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV21LiqDCalculado = (byte)(1) ;
      /* Using cursor P017K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8AplIIGG)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1112AplIIGG = P017K2_A1112AplIIGG[0] ;
         A3CliCod = P017K2_A3CliCod[0] ;
         A1114AplIIGGPropor = P017K2_A1114AplIIGGPropor[0] ;
         A1115AplIIGGTopeTip = P017K2_A1115AplIIGGTopeTip[0] ;
         A1109AplIIGGTopeVar = P017K2_A1109AplIIGGTopeVar[0] ;
         n1109AplIIGGTopeVar = P017K2_n1109AplIIGGTopeVar[0] ;
         A1121AplIIGGPrrtear = P017K2_A1121AplIIGGPrrtear[0] ;
         A1119AplIIGGTopeFij = P017K2_A1119AplIIGGTopeFij[0] ;
         A1111AplIIGGTopeCon = P017K2_A1111AplIIGGTopeCon[0] ;
         n1111AplIIGGTopeCon = P017K2_n1111AplIIGGTopeCon[0] ;
         AV23AplIIGGPropor = A1114AplIIGGPropor ;
         AV27AplIIGGTopeTip = A1115AplIIGGTopeTip ;
         AV28AplIIGGTopeVar = A1109AplIIGGTopeVar ;
         AV9AplIIGGPrrtear = A1121AplIIGGPrrtear ;
         if ( A1115AplIIGGTopeTip == 3 )
         {
            AV12importes = A1119AplIIGGTopeFij ;
            AV29topePalabra = httpContext.getMessage( "tope", "") ;
         }
         else if ( A1115AplIIGGTopeTip == 1 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "TipoTope.Variable", "")) ;
            GXv_char1[0] = AV13OpeCliValor ;
            GXv_char2[0] = AV30error ;
            new web.getopeclivalor(remoteHandle, context).execute( AV10CliCod, A1109AplIIGGTopeVar, AV14LiqPeriodo, AV24ProcesoLiquidacion, GXv_char1, GXv_char2) ;
            getapliiggtope.this.AV13OpeCliValor = GXv_char1[0] ;
            getapliiggtope.this.AV30error = GXv_char2[0] ;
            if ( ! (GXutil.strcmp("", AV30error)==0) )
            {
               AV21LiqDCalculado = (byte)(0) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV12importes = CommonUtil.decimalVal( AV13OpeCliValor, ".") ;
            AV29topePalabra = A1109AplIIGGTopeVar ;
         }
         else if ( A1115AplIIGGTopeTip == 2 )
         {
            AV29topePalabra = httpContext.getMessage( "concepto ", "") + GXutil.trim( A1111AplIIGGTopeCon) ;
            GXv_decimal3[0] = AV15LiqDImpCalcu ;
            GXv_boolean4[0] = AV26existe ;
            GXv_int5[0] = AV19topeLiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV20EmpCod, AV16LiqNro, AV17LegNumero, A1111AplIIGGTopeCon, AV24ProcesoLiquidacion, AV25insertandoConceptos, GXv_decimal3, GXv_boolean4, GXv_int5) ;
            getapliiggtope.this.AV15LiqDImpCalcu = GXv_decimal3[0] ;
            getapliiggtope.this.AV26existe = GXv_boolean4[0] ;
            getapliiggtope.this.AV19topeLiqDCalculado = GXv_int5[0] ;
            if ( ( AV19topeLiqDCalculado == 0 ) && ( AV26existe ) )
            {
               AV21LiqDCalculado = (byte)(0) ;
               AV12importes = DecimalUtil.ZERO ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV12importes = AV15LiqDImpCalcu ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "&importes ", "")+GXutil.trim( GXutil.str( AV12importes, 14, 2))) ;
      if ( AV12importes.doubleValue() < 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV34Pgmname, httpContext.getMessage( "cerea", "")) ;
         AV12importes = DecimalUtil.doubleToDec(0) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = getapliiggtope.this.AV12importes;
      this.aP9[0] = getapliiggtope.this.AV23AplIIGGPropor;
      this.aP10[0] = getapliiggtope.this.AV27AplIIGGTopeTip;
      this.aP11[0] = getapliiggtope.this.AV28AplIIGGTopeVar;
      this.aP12[0] = getapliiggtope.this.AV9AplIIGGPrrtear;
      this.aP13[0] = getapliiggtope.this.AV29topePalabra;
      this.aP14[0] = getapliiggtope.this.AV21LiqDCalculado;
      this.aP15[0] = getapliiggtope.this.AV30error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12importes = DecimalUtil.ZERO ;
      AV23AplIIGGPropor = DecimalUtil.ZERO ;
      AV28AplIIGGTopeVar = "" ;
      AV9AplIIGGPrrtear = "" ;
      AV29topePalabra = "" ;
      AV30error = "" ;
      scmdbuf = "" ;
      P017K2_A1112AplIIGG = new short[1] ;
      P017K2_A3CliCod = new int[1] ;
      P017K2_A1114AplIIGGPropor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017K2_A1115AplIIGGTopeTip = new byte[1] ;
      P017K2_A1109AplIIGGTopeVar = new String[] {""} ;
      P017K2_n1109AplIIGGTopeVar = new boolean[] {false} ;
      P017K2_A1121AplIIGGPrrtear = new String[] {""} ;
      P017K2_A1119AplIIGGTopeFij = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017K2_A1111AplIIGGTopeCon = new String[] {""} ;
      P017K2_n1111AplIIGGTopeCon = new boolean[] {false} ;
      A1114AplIIGGPropor = DecimalUtil.ZERO ;
      A1109AplIIGGTopeVar = "" ;
      A1121AplIIGGPrrtear = "" ;
      A1119AplIIGGTopeFij = DecimalUtil.ZERO ;
      A1111AplIIGGTopeCon = "" ;
      AV34Pgmname = "" ;
      AV13OpeCliValor = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      AV15LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_int5 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getapliiggtope__default(),
         new Object[] {
             new Object[] {
            P017K2_A1112AplIIGG, P017K2_A3CliCod, P017K2_A1114AplIIGGPropor, P017K2_A1115AplIIGGTopeTip, P017K2_A1109AplIIGGTopeVar, P017K2_n1109AplIIGGTopeVar, P017K2_A1121AplIIGGPrrtear, P017K2_A1119AplIIGGTopeFij, P017K2_A1111AplIIGGTopeCon, P017K2_n1111AplIIGGTopeCon
            }
         }
      );
      AV34Pgmname = "getAplIIGGTope" ;
      /* GeneXus formulas. */
      AV34Pgmname = "getAplIIGGTope" ;
      Gx_err = (short)(0) ;
   }

   private byte AV27AplIIGGTopeTip ;
   private byte AV21LiqDCalculado ;
   private byte A1115AplIIGGTopeTip ;
   private byte AV19topeLiqDCalculado ;
   private byte GXv_int5[] ;
   private short AV20EmpCod ;
   private short AV8AplIIGG ;
   private short A1112AplIIGG ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV16LiqNro ;
   private int AV17LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV12importes ;
   private java.math.BigDecimal AV23AplIIGGPropor ;
   private java.math.BigDecimal A1114AplIIGGPropor ;
   private java.math.BigDecimal A1119AplIIGGTopeFij ;
   private java.math.BigDecimal AV15LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV24ProcesoLiquidacion ;
   private String AV28AplIIGGTopeVar ;
   private String AV9AplIIGGPrrtear ;
   private String AV29topePalabra ;
   private String scmdbuf ;
   private String A1109AplIIGGTopeVar ;
   private String A1121AplIIGGPrrtear ;
   private String A1111AplIIGGTopeCon ;
   private String AV34Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV25insertandoConceptos ;
   private boolean n1109AplIIGGTopeVar ;
   private boolean n1111AplIIGGTopeCon ;
   private boolean returnInSub ;
   private boolean AV26existe ;
   private boolean GXv_boolean4[] ;
   private String AV13OpeCliValor ;
   private String AV30error ;
   private String[] aP15 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private byte[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private byte[] aP14 ;
   private IDataStoreProvider pr_default ;
   private short[] P017K2_A1112AplIIGG ;
   private int[] P017K2_A3CliCod ;
   private java.math.BigDecimal[] P017K2_A1114AplIIGGPropor ;
   private byte[] P017K2_A1115AplIIGGTopeTip ;
   private String[] P017K2_A1109AplIIGGTopeVar ;
   private boolean[] P017K2_n1109AplIIGGTopeVar ;
   private String[] P017K2_A1121AplIIGGPrrtear ;
   private java.math.BigDecimal[] P017K2_A1119AplIIGGTopeFij ;
   private String[] P017K2_A1111AplIIGGTopeCon ;
   private boolean[] P017K2_n1111AplIIGGTopeCon ;
}

final  class getapliiggtope__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017K2", "SELECT AplIIGG, CliCod, AplIIGGPropor, AplIIGGTopeTip, AplIIGGTopeVar, AplIIGGPrrtear, AplIIGGTopeFij, AplIIGGTopeCon FROM tipo_aplicacion_ganancias WHERE CliCod = ? and AplIIGG = ? ORDER BY CliCod, AplIIGG ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[8])[0] = rslt.getString(8, 10);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
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
               return;
      }
   }

}

