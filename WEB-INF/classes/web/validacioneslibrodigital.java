package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validacioneslibrodigital extends GXProcedure
{
   public validacioneslibrodigital( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validacioneslibrodigital.class ), "" );
   }

   public validacioneslibrodigital( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             int aP3 )
   {
      validacioneslibrodigital.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        int aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             int aP3 ,
                             String[] aP4 )
   {
      validacioneslibrodigital.this.AV10CliCod = aP0;
      validacioneslibrodigital.this.AV13EmpCod = aP1;
      validacioneslibrodigital.this.AV21PeriodoLiq = aP2;
      validacioneslibrodigital.this.AV15LiqNro = aP3;
      validacioneslibrodigital.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00EP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV13EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P00EP2_A1EmpCod[0] ;
         A3CliCod = P00EP2_A3CliCod[0] ;
         A45TipEmpleCod = P00EP2_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P00EP2_n45TipEmpleCod[0] ;
         A177EmpCUIT = P00EP2_A177EmpCUIT[0] ;
         if ( P00EP2_n45TipEmpleCod[0] )
         {
            AV14error = httpContext.getMessage( "Debe ingresar \"Tipo de Empleador\" en empresa.", "") ;
            new web.alert(remoteHandle, context).execute( "error", AV14error) ;
         }
         if ( (0==A177EmpCUIT) )
         {
            AV14error = httpContext.getMessage( "Debe ingresar CUIT de empresa", "") ;
            new web.alert(remoteHandle, context).execute( "error", AV14error) ;
         }
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Integer.valueOf(AV15LiqNro) ,
                                           AV21PeriodoLiq ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A1729PeriodoLiq ,
                                           A281LiqLegImpTotal ,
                                           A306OsoC3992 ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV13EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DECIMAL, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00EP3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV15LiqNro), AV21PeriodoLiq});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1965EmpOsoCod = P00EP3_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = P00EP3_n1965EmpOsoCod[0] ;
         A306OsoC3992 = P00EP3_A306OsoC3992[0] ;
         n306OsoC3992 = P00EP3_n306OsoC3992[0] ;
         A281LiqLegImpTotal = P00EP3_A281LiqLegImpTotal[0] ;
         A1729PeriodoLiq = P00EP3_A1729PeriodoLiq[0] ;
         A31LiqNro = P00EP3_A31LiqNro[0] ;
         A1EmpCod = P00EP3_A1EmpCod[0] ;
         A3CliCod = P00EP3_A3CliCod[0] ;
         A6LegNumero = P00EP3_A6LegNumero[0] ;
         A1965EmpOsoCod = P00EP3_A1965EmpOsoCod[0] ;
         n1965EmpOsoCod = P00EP3_n1965EmpOsoCod[0] ;
         A306OsoC3992 = P00EP3_A306OsoC3992[0] ;
         n306OsoC3992 = P00EP3_n306OsoC3992[0] ;
         A1729PeriodoLiq = P00EP3_A1729PeriodoLiq[0] ;
         AV14error = httpContext.getMessage( "Todos los Legajos deben tener código AFIP de Obra Social", "") ;
         new web.alert(remoteHandle, context).execute( "error", AV14error) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      GXt_char1 = AV16MaternidadAnses ;
      GXt_char2 = AV16MaternidadAnses ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_licenciapormaternidad_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      validacioneslibrodigital.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      validacioneslibrodigital.this.GXt_char1 = GXv_char4[0] ;
      AV16MaternidadAnses = GXt_char1 ;
      GXt_char2 = AV17SueldoBasico ;
      GXt_char1 = AV17SueldoBasico ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validacioneslibrodigital.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      validacioneslibrodigital.this.GXt_char2 = GXv_char3[0] ;
      AV17SueldoBasico = GXt_char2 ;
      GXt_char2 = AV18SueldoBasicoMensual ;
      GXt_char1 = AV18SueldoBasicoMensual ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      validacioneslibrodigital.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      validacioneslibrodigital.this.GXt_char2 = GXv_char3[0] ;
      AV18SueldoBasicoMensual = GXt_char2 ;
      if ( (GXutil.strcmp("", AV16MaternidadAnses)==0) || (GXutil.strcmp("", AV17SueldoBasico)==0) || (GXutil.strcmp("", AV18SueldoBasicoMensual)==0) )
      {
         if ( (GXutil.strcmp("", AV16MaternidadAnses)==0) )
         {
            AV14error += httpContext.getMessage( "Falta parametrizar concepto para Maternidad. ", "") ;
         }
         if ( (GXutil.strcmp("", AV17SueldoBasico)==0) )
         {
            AV14error += httpContext.getMessage( "Falta parametrizar concepto para Sueldo básico jornal. ", "") ;
         }
         if ( (GXutil.strcmp("", AV18SueldoBasicoMensual)==0) )
         {
            AV14error += httpContext.getMessage( "Falta parametrizar concepto para Sueldo básico mensual. ", "") ;
         }
         new web.alert(remoteHandle, context).execute( "error", AV14error) ;
      }
      /* Using cursor P00EP4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV10CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1648ConCodAfip = P00EP4_A1648ConCodAfip[0] ;
         A37TipoConCod = P00EP4_A37TipoConCod[0] ;
         A150ConHabilitado = P00EP4_A150ConHabilitado[0] ;
         A3CliCod = P00EP4_A3CliCod[0] ;
         A26ConCodigo = P00EP4_A26ConCodigo[0] ;
         if ( (GXutil.strcmp("", AV14error)==0) )
         {
            AV14error = httpContext.getMessage( "Configuración de equivalencias de conceptos de AFIP incompleta.", "") ;
         }
         AV20ConCodPropio.add(A26ConCodigo, 0);
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( (GXutil.strcmp("", AV14error)==0) )
      {
         /* Using cursor P00EP5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV15LiqNro)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A31LiqNro = P00EP5_A31LiqNro[0] ;
            A1EmpCod = P00EP5_A1EmpCod[0] ;
            A3CliCod = P00EP5_A3CliCod[0] ;
            A2292LiqLSDDepEst = P00EP5_A2292LiqLSDDepEst[0] ;
            if ( A2292LiqLSDDepEst != 3 )
            {
               AV14error = httpContext.getMessage( "Falta el cálculo de las bases imponibles de contribuciones. Inténtelo nuevamente cuando el proceso de liquidación termine de calcular las dependencias de LSD", "") ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(3);
      }
      if ( ! (GXutil.strcmp("", AV14error)==0) )
      {
         AV14error += " " ;
         if ( AV20ConCodPropio.size() > 0 )
         {
            AV14error += AV20ConCodPropio.toJSonString(false) ;
         }
         AV14error = GXutil.strReplace( AV14error, "[", "(") ;
         AV14error = GXutil.strReplace( AV14error, "]", ")") ;
         new web.alert(remoteHandle, context).execute( "error", AV14error) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = validacioneslibrodigital.this.AV14error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      scmdbuf = "" ;
      P00EP2_A1EmpCod = new short[1] ;
      P00EP2_A3CliCod = new int[1] ;
      P00EP2_A45TipEmpleCod = new String[] {""} ;
      P00EP2_n45TipEmpleCod = new boolean[] {false} ;
      P00EP2_A177EmpCUIT = new long[1] ;
      A45TipEmpleCod = "" ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A306OsoC3992 = "" ;
      P00EP3_A1965EmpOsoCod = new String[] {""} ;
      P00EP3_n1965EmpOsoCod = new boolean[] {false} ;
      P00EP3_A306OsoC3992 = new String[] {""} ;
      P00EP3_n306OsoC3992 = new boolean[] {false} ;
      P00EP3_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00EP3_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P00EP3_A31LiqNro = new int[1] ;
      P00EP3_A1EmpCod = new short[1] ;
      P00EP3_A3CliCod = new int[1] ;
      P00EP3_A6LegNumero = new int[1] ;
      A1965EmpOsoCod = "" ;
      AV16MaternidadAnses = "" ;
      AV17SueldoBasico = "" ;
      AV18SueldoBasicoMensual = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      P00EP4_A1648ConCodAfip = new String[] {""} ;
      P00EP4_A37TipoConCod = new String[] {""} ;
      P00EP4_A150ConHabilitado = new boolean[] {false} ;
      P00EP4_A3CliCod = new int[1] ;
      P00EP4_A26ConCodigo = new String[] {""} ;
      A1648ConCodAfip = "" ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      AV20ConCodPropio = new GXSimpleCollection<String>(String.class, "internal", "");
      P00EP5_A31LiqNro = new int[1] ;
      P00EP5_A1EmpCod = new short[1] ;
      P00EP5_A3CliCod = new int[1] ;
      P00EP5_A2292LiqLSDDepEst = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.validacioneslibrodigital__default(),
         new Object[] {
             new Object[] {
            P00EP2_A1EmpCod, P00EP2_A3CliCod, P00EP2_A45TipEmpleCod, P00EP2_n45TipEmpleCod, P00EP2_A177EmpCUIT
            }
            , new Object[] {
            P00EP3_A1965EmpOsoCod, P00EP3_n1965EmpOsoCod, P00EP3_A306OsoC3992, P00EP3_n306OsoC3992, P00EP3_A281LiqLegImpTotal, P00EP3_A1729PeriodoLiq, P00EP3_A31LiqNro, P00EP3_A1EmpCod, P00EP3_A3CliCod, P00EP3_A6LegNumero
            }
            , new Object[] {
            P00EP4_A1648ConCodAfip, P00EP4_A37TipoConCod, P00EP4_A150ConHabilitado, P00EP4_A3CliCod, P00EP4_A26ConCodigo
            }
            , new Object[] {
            P00EP5_A31LiqNro, P00EP5_A1EmpCod, P00EP5_A3CliCod, P00EP5_A2292LiqLSDDepEst
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2292LiqLSDDepEst ;
   private short AV13EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV15LiqNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private long A177EmpCUIT ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String scmdbuf ;
   private String A45TipEmpleCod ;
   private String A306OsoC3992 ;
   private String A1965EmpOsoCod ;
   private String AV16MaternidadAnses ;
   private String AV17SueldoBasico ;
   private String AV18SueldoBasicoMensual ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String A1648ConCodAfip ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private java.util.Date AV21PeriodoLiq ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean n45TipEmpleCod ;
   private boolean n1965EmpOsoCod ;
   private boolean n306OsoC3992 ;
   private boolean A150ConHabilitado ;
   private String AV14error ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P00EP2_A1EmpCod ;
   private int[] P00EP2_A3CliCod ;
   private String[] P00EP2_A45TipEmpleCod ;
   private boolean[] P00EP2_n45TipEmpleCod ;
   private long[] P00EP2_A177EmpCUIT ;
   private String[] P00EP3_A1965EmpOsoCod ;
   private boolean[] P00EP3_n1965EmpOsoCod ;
   private String[] P00EP3_A306OsoC3992 ;
   private boolean[] P00EP3_n306OsoC3992 ;
   private java.math.BigDecimal[] P00EP3_A281LiqLegImpTotal ;
   private java.util.Date[] P00EP3_A1729PeriodoLiq ;
   private int[] P00EP3_A31LiqNro ;
   private short[] P00EP3_A1EmpCod ;
   private int[] P00EP3_A3CliCod ;
   private int[] P00EP3_A6LegNumero ;
   private String[] P00EP4_A1648ConCodAfip ;
   private String[] P00EP4_A37TipoConCod ;
   private boolean[] P00EP4_A150ConHabilitado ;
   private int[] P00EP4_A3CliCod ;
   private String[] P00EP4_A26ConCodigo ;
   private int[] P00EP5_A31LiqNro ;
   private short[] P00EP5_A1EmpCod ;
   private int[] P00EP5_A3CliCod ;
   private byte[] P00EP5_A2292LiqLSDDepEst ;
   private GXSimpleCollection<String> AV20ConCodPropio ;
}

final  class validacioneslibrodigital__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00EP3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV15LiqNro ,
                                          java.util.Date AV21PeriodoLiq ,
                                          int A31LiqNro ,
                                          java.util.Date A1729PeriodoLiq ,
                                          java.math.BigDecimal A281LiqLegImpTotal ,
                                          String A306OsoC3992 ,
                                          int AV10CliCod ,
                                          short AV13EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[4];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT T2.EmpOsoCod AS EmpOsoCod, T3.OsoC3992, T1.LiqLegImpTotal, T4.PeriodoLiq, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LegNumero FROM (((LiquidacionLegajo T1 INNER" ;
      scmdbuf += " JOIN Empresa T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod) LEFT JOIN ObraSocial T3 ON T3.CliCod = T1.CliCod AND T3.OsoCod = T2.EmpOsoCod) INNER JOIN Liquidacion" ;
      scmdbuf += " T4 ON T4.CliCod = T1.CliCod AND T4.EmpCod = T1.EmpCod AND T4.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LiqLegImpTotal <> 0)");
      addWhere(sWhereString, "((char_length(trim(trailing ' ' from T3.OsoC3992))=0))");
      if ( ! (0==AV15LiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro = ?)");
      }
      else
      {
         GXv_int5[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV21PeriodoLiq)) )
      {
         addWhere(sWhereString, "(T4.PeriodoLiq = ?)");
      }
      else
      {
         GXv_int5[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_P00EP3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (java.util.Date)dynConstraints[3] , (java.math.BigDecimal)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00EP2", "SELECT EmpCod, CliCod, TipEmpleCod, EmpCUIT FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00EP3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00EP4", "SELECT ConCodAfip, TipoConCod, ConHabilitado, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (TipoConCod <> ( 'CAL_ARG')) AND ((char_length(trim(trailing ' ' from ConCodAfip))=0)) AND (ConHabilitado = TRUE) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00EP5", "SELECT LiqNro, EmpCod, CliCod, LiqLSDDepEst FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 4);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((long[]) buf[4])[0] = rslt.getLong(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(3,2);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(4);
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
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
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

