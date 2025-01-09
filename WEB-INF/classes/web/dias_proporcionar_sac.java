package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dias_proporcionar_sac extends GXProcedure
{
   public dias_proporcionar_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dias_proporcionar_sac.class ), "" );
   }

   public dias_proporcionar_sac( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           String aP5 ,
                           boolean aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           String[] aP8 ,
                           String[] aP9 )
   {
      dias_proporcionar_sac.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      dias_proporcionar_sac.this.AV14CliCod = aP0;
      dias_proporcionar_sac.this.AV15EmpCod = aP1;
      dias_proporcionar_sac.this.AV16LiqNro = aP2;
      dias_proporcionar_sac.this.AV17LegNumero = aP3;
      dias_proporcionar_sac.this.AV29LiqPeriodo = aP4;
      dias_proporcionar_sac.this.AV25ProcesoLiquidacion = aP5;
      dias_proporcionar_sac.this.AV28insertandoConceptos = aP6;
      dias_proporcionar_sac.this.aP7 = aP7;
      dias_proporcionar_sac.this.aP8 = aP8;
      dias_proporcionar_sac.this.aP9 = aP9;
      dias_proporcionar_sac.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9diasPropTopeConCodigo ;
      GXt_char2 = AV9diasPropTopeConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      dias_proporcionar_sac.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char2, GXv_char4) ;
      dias_proporcionar_sac.this.GXt_char1 = GXv_char4[0] ;
      AV9diasPropTopeConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV10auxLiqDCanti ;
      GXv_boolean6[0] = AV30existe ;
      GXv_int7[0] = AV12auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV14CliCod, AV15EmpCod, AV16LiqNro, AV17LegNumero, AV9diasPropTopeConCodigo, AV25ProcesoLiquidacion, AV28insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      dias_proporcionar_sac.this.AV10auxLiqDCanti = GXv_decimal5[0] ;
      dias_proporcionar_sac.this.AV30existe = GXv_boolean6[0] ;
      dias_proporcionar_sac.this.AV12auxLiqDCalculado = GXv_int7[0] ;
      if ( ( AV12auxLiqDCalculado == 0 ) && ( AV30existe ) )
      {
         AV19error = httpContext.getMessage( "Falta calcular días para proporcionar tope imponible (concepto ", "") + GXutil.trim( AV9diasPropTopeConCodigo) + ")" ;
         AV13LiqDCalculado = (byte)(0) ;
         AV20LiqDLog = AV19error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV21LiqDCanti = AV10auxLiqDCanti ;
      AV20LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV10auxLiqDCanti, 14, 2)) + httpContext.getMessage( " de los días para proporcionar tope imponible", "") ;
      GXv_objcol_char8[0] = AV22excluidosSACConCodigo ;
      new web.sac_conceptos_excluidos(remoteHandle, context).execute( AV14CliCod, true, false, GXv_objcol_char8) ;
      AV22excluidosSACConCodigo = GXv_objcol_char8[0] ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A394DConCodigo ,
                                           AV22excluidosSACConCodigo ,
                                           Integer.valueOf(AV14CliCod) ,
                                           Short.valueOf(AV15EmpCod) ,
                                           Integer.valueOf(AV16LiqNro) ,
                                           Integer.valueOf(AV17LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01BN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV15EmpCod), Integer.valueOf(AV16LiqNro), Integer.valueOf(AV17LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A394DConCodigo = P01BN2_A394DConCodigo[0] ;
         A6LegNumero = P01BN2_A6LegNumero[0] ;
         A31LiqNro = P01BN2_A31LiqNro[0] ;
         A1EmpCod = P01BN2_A1EmpCod[0] ;
         A3CliCod = P01BN2_A3CliCod[0] ;
         A507LiqDCalculado = P01BN2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01BN2_A763LiqDRecalculado[0] ;
         A393DConDescrip = P01BN2_A393DConDescrip[0] ;
         A275LiqDImpCalcu = P01BN2_A275LiqDImpCalcu[0] ;
         n275LiqDImpCalcu = P01BN2_n275LiqDImpCalcu[0] ;
         A269LiqDCanti = P01BN2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01BN2_n269LiqDCanti[0] ;
         A81LiqDSecuencial = P01BN2_A81LiqDSecuencial[0] ;
         GXv_char4[0] = AV23ConCondicion ;
         GXv_char3[0] = AV26SitCodigo ;
         new web.getconceptocondicion(remoteHandle, context).execute( AV14CliCod, A394DConCodigo, GXv_char4, GXv_char3) ;
         dias_proporcionar_sac.this.AV23ConCondicion = GXv_char4[0] ;
         dias_proporcionar_sac.this.AV26SitCodigo = GXv_char3[0] ;
         if ( GXutil.strcmp(AV23ConCondicion, "B1") == 0 )
         {
            GXv_boolean6[0] = false ;
            GXv_boolean9[0] = false ;
            GXv_boolean10[0] = AV24SitLicCuentaTrab ;
            GXv_boolean11[0] = false ;
            GXv_boolean12[0] = false ;
            GXv_boolean13[0] = false ;
            GXv_boolean14[0] = false ;
            new web.getsituacionlicenciaprops(remoteHandle, context).execute( AV26SitCodigo, GXv_boolean6, GXv_boolean9, GXv_boolean10, GXv_boolean11, GXv_boolean12, GXv_boolean13, GXv_boolean14) ;
            dias_proporcionar_sac.this.AV24SitLicCuentaTrab = GXv_boolean10[0] ;
            if ( AV24SitLicCuentaTrab )
            {
               new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
               GXv_int7[0] = AV12auxLiqDCalculado ;
               new web.dependenciaresuelta2(remoteHandle, context).execute( AV14CliCod, A394DConCodigo, AV25ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int7) ;
               dias_proporcionar_sac.this.AV12auxLiqDCalculado = GXv_int7[0] ;
               if ( AV12auxLiqDCalculado == 0 )
               {
                  AV13LiqDCalculado = (byte)(0) ;
                  AV19error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
                  AV20LiqDLog += ". " + GXutil.trim( AV19error) ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( A275LiqDImpCalcu.doubleValue() != 0 )
               {
                  AV21LiqDCanti = AV21LiqDCanti.subtract(A269LiqDCanti) ;
                  AV20LiqDLog += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " días de concepto excluido de sac ", "") + GXutil.trim( A393DConDescrip) ;
               }
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = dias_proporcionar_sac.this.AV21LiqDCanti;
      this.aP8[0] = dias_proporcionar_sac.this.AV19error;
      this.aP9[0] = dias_proporcionar_sac.this.AV20LiqDLog;
      this.aP10[0] = dias_proporcionar_sac.this.AV13LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21LiqDCanti = DecimalUtil.ZERO ;
      AV19error = "" ;
      AV20LiqDLog = "" ;
      AV9diasPropTopeConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV10auxLiqDCanti = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV22excluidosSACConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char8 = new GXSimpleCollection[1] ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      P01BN2_A394DConCodigo = new String[] {""} ;
      P01BN2_A6LegNumero = new int[1] ;
      P01BN2_A31LiqNro = new int[1] ;
      P01BN2_A1EmpCod = new short[1] ;
      P01BN2_A3CliCod = new int[1] ;
      P01BN2_A507LiqDCalculado = new byte[1] ;
      P01BN2_A763LiqDRecalculado = new short[1] ;
      P01BN2_A393DConDescrip = new String[] {""} ;
      P01BN2_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01BN2_n275LiqDImpCalcu = new boolean[] {false} ;
      P01BN2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01BN2_n269LiqDCanti = new boolean[] {false} ;
      P01BN2_A81LiqDSecuencial = new int[1] ;
      A393DConDescrip = "" ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      AV23ConCondicion = "" ;
      GXv_char4 = new String[1] ;
      AV26SitCodigo = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_boolean10 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      GXv_boolean12 = new boolean[1] ;
      GXv_boolean13 = new boolean[1] ;
      GXv_boolean14 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.dias_proporcionar_sac__default(),
         new Object[] {
             new Object[] {
            P01BN2_A394DConCodigo, P01BN2_A6LegNumero, P01BN2_A31LiqNro, P01BN2_A1EmpCod, P01BN2_A3CliCod, P01BN2_A507LiqDCalculado, P01BN2_A763LiqDRecalculado, P01BN2_A393DConDescrip, P01BN2_A275LiqDImpCalcu, P01BN2_n275LiqDImpCalcu,
            P01BN2_A269LiqDCanti, P01BN2_n269LiqDCanti, P01BN2_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte AV12auxLiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV15EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV16LiqNro ;
   private int AV17LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV21LiqDCanti ;
   private java.math.BigDecimal AV10auxLiqDCanti ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV25ProcesoLiquidacion ;
   private String AV9diasPropTopeConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String AV23ConCondicion ;
   private String GXv_char4[] ;
   private String AV26SitCodigo ;
   private String GXv_char3[] ;
   private java.util.Date AV29LiqPeriodo ;
   private boolean AV28insertandoConceptos ;
   private boolean AV30existe ;
   private boolean returnInSub ;
   private boolean n275LiqDImpCalcu ;
   private boolean n269LiqDCanti ;
   private boolean GXv_boolean6[] ;
   private boolean GXv_boolean9[] ;
   private boolean AV24SitLicCuentaTrab ;
   private boolean GXv_boolean10[] ;
   private boolean GXv_boolean11[] ;
   private boolean GXv_boolean12[] ;
   private boolean GXv_boolean13[] ;
   private boolean GXv_boolean14[] ;
   private String AV20LiqDLog ;
   private String AV19error ;
   private String A393DConDescrip ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01BN2_A394DConCodigo ;
   private int[] P01BN2_A6LegNumero ;
   private int[] P01BN2_A31LiqNro ;
   private short[] P01BN2_A1EmpCod ;
   private int[] P01BN2_A3CliCod ;
   private byte[] P01BN2_A507LiqDCalculado ;
   private short[] P01BN2_A763LiqDRecalculado ;
   private String[] P01BN2_A393DConDescrip ;
   private java.math.BigDecimal[] P01BN2_A275LiqDImpCalcu ;
   private boolean[] P01BN2_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01BN2_A269LiqDCanti ;
   private boolean[] P01BN2_n269LiqDCanti ;
   private int[] P01BN2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV22excluidosSACConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char8[] ;
}

final  class dias_proporcionar_sac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01BN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV22excluidosSACConCodigo ,
                                          int AV14CliCod ,
                                          short AV15EmpCod ,
                                          int AV16LiqNro ,
                                          int AV17LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[4];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDImpCalcu, LiqDCanti, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22excluidosSACConCodigo, "DConCodigo IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01BN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
      }
   }

}

