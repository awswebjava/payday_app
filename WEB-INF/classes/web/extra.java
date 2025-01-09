package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class extra extends GXProcedure
{
   public extra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( extra.class ), "" );
   }

   public extra( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      extra.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      extra.this.AV26CliCod = aP0;
      extra.this.AV21EmpCod = aP1;
      extra.this.AV28LegNumero = aP2;
      extra.this.AV12PaiCod = aP3;
      extra.this.AV33tipoTrabajoPalabra = aP4;
      extra.this.AV31diaPalabra = aP5;
      extra.this.AV19horaDesde = aP6;
      extra.this.AV29busca = aP7;
      extra.this.aP8 = aP8;
      extra.this.aP9 = aP9;
      extra.this.aP10 = aP10;
      extra.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV11LegConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV26CliCod, AV21EmpCod, AV28LegNumero, GXv_char1) ;
      extra.this.AV11LegConveCodigo = GXv_char1[0] ;
      AV30tipo_trabajo = AV33tipoTrabajoPalabra ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&diaPalabra ", "")+GXutil.trim( AV31diaPalabra)) ;
      if ( (GXutil.strcmp("", AV31diaPalabra)==0) )
      {
         AV40error = httpContext.getMessage( "No se especificó día de hora extra", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         AV8determina_extra = "porDia" ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&determina_extra ", "")+AV8determina_extra) ;
      GXv_int2[0] = AV36CliConveVer ;
      new web.getversiondelegajo(remoteHandle, context).execute( AV26CliCod, AV21EmpCod, AV28LegNumero, GXv_int2) ;
      extra.this.AV36CliConveVer = GXv_int2[0] ;
      if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "DOMINGO", "")) == 0 )
      {
         AV18dia_tra = (byte)(1) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "LUNES", "")) == 0 )
      {
         AV18dia_tra = (byte)(2) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "MARTES", "")) == 0 )
      {
         AV18dia_tra = (byte)(3) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "MIERCOLES", "")) == 0 )
      {
         AV18dia_tra = (byte)(4) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "JUEVES", "")) == 0 )
      {
         AV18dia_tra = (byte)(5) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "VIERNES", "")) == 0 )
      {
         AV18dia_tra = (byte)(6) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "SABADO", "")) == 0 )
      {
         AV18dia_tra = (byte)(7) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "FERIADO", "")) == 0 )
      {
         AV18dia_tra = (byte)(8) ;
      }
      else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV31diaPalabra)), httpContext.getMessage( "HABIL", "")) == 0 )
      {
         AV18dia_tra = (byte)(9) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&dia_tra ", "")+GXutil.trim( GXutil.str( AV18dia_tra, 1, 0))) ;
      if ( ! (GXutil.strcmp("", AV11LegConveCodigo)==0) )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV19horaDesde ,
                                              A1329ConveHsPDiaDesde ,
                                              Byte.valueOf(A1328ConveHsPDiaDia) ,
                                              Byte.valueOf(AV18dia_tra) ,
                                              Integer.valueOf(AV36CliConveVer) ,
                                              Short.valueOf(AV12PaiCod) ,
                                              AV11LegConveCodigo ,
                                              AV30tipo_trabajo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              A1565CliConvenio ,
                                              A1326ConvHsPDiaTipTra } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                              TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         /* Using cursor P01CE2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliConveVer), Short.valueOf(AV12PaiCod), AV11LegConveCodigo, AV30tipo_trabajo, Byte.valueOf(AV18dia_tra), AV19horaDesde});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1329ConveHsPDiaDesde = P01CE2_A1329ConveHsPDiaDesde[0] ;
            n1329ConveHsPDiaDesde = P01CE2_n1329ConveHsPDiaDesde[0] ;
            A1328ConveHsPDiaDia = P01CE2_A1328ConveHsPDiaDia[0] ;
            A1326ConvHsPDiaTipTra = P01CE2_A1326ConvHsPDiaTipTra[0] ;
            A1565CliConvenio = P01CE2_A1565CliConvenio[0] ;
            A1564CliPaiConve = P01CE2_A1564CliPaiConve[0] ;
            A3CliCod = P01CE2_A3CliCod[0] ;
            A1330ConveTarifaPDia = P01CE2_A1330ConveTarifaPDia[0] ;
            A1350ConveTarifaPDRec = P01CE2_A1350ConveTarifaPDRec[0] ;
            A1327ConveHsExSec = P01CE2_A1327ConveHsExSec[0] ;
            if ( GXutil.strcmp(AV29busca, httpContext.getMessage( "extra", "")) == 0 )
            {
               AV15porUnaje = A1330ConveTarifaPDia ;
            }
            else
            {
               AV15porUnaje = A1350ConveTarifaPDRec ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15porUnaje)==0) )
         {
            AV34definido = httpContext.getMessage( "convenio / esquema tarifario", "") ;
         }
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15porUnaje)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&tipo_trabajo ", "")+GXutil.trim( AV30tipo_trabajo)+httpContext.getMessage( " &horaDesde ", "")+GXutil.trim( AV19horaDesde)) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              AV19horaDesde ,
                                              A1342EmpHsPDiaDesde ,
                                              Byte.valueOf(A1341EmpHsPDiaDia) ,
                                              Byte.valueOf(AV18dia_tra) ,
                                              Integer.valueOf(AV26CliCod) ,
                                              Short.valueOf(AV21EmpCod) ,
                                              AV30tipo_trabajo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              A1339EmpHsPDiaTipTra } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.STRING
                                              }
         });
         /* Using cursor P01CE3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV21EmpCod), AV30tipo_trabajo, Byte.valueOf(AV18dia_tra), AV19horaDesde});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1342EmpHsPDiaDesde = P01CE3_A1342EmpHsPDiaDesde[0] ;
            n1342EmpHsPDiaDesde = P01CE3_n1342EmpHsPDiaDesde[0] ;
            A1341EmpHsPDiaDia = P01CE3_A1341EmpHsPDiaDia[0] ;
            A1339EmpHsPDiaTipTra = P01CE3_A1339EmpHsPDiaTipTra[0] ;
            A1EmpCod = P01CE3_A1EmpCod[0] ;
            A3CliCod = P01CE3_A3CliCod[0] ;
            A1343EmpTarifaPDia = P01CE3_A1343EmpTarifaPDia[0] ;
            A1351EmpTarfaPDRec = P01CE3_A1351EmpTarfaPDRec[0] ;
            A1340EmpHsExSec = P01CE3_A1340EmpHsExSec[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&busca ", "")+GXutil.trim( AV29busca)) ;
            if ( GXutil.strcmp(AV29busca, httpContext.getMessage( "extra", "")) == 0 )
            {
               AV15porUnaje = A1343EmpTarifaPDia ;
            }
            else
            {
               AV15porUnaje = A1351EmpTarfaPDRec ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&porUnaje ", "")+GXutil.trim( GXutil.str( AV15porUnaje, 6, 4))) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15porUnaje)==0) )
         {
            AV34definido = httpContext.getMessage( "empresa", "") ;
         }
      }
      if ( GXutil.strcmp(AV29busca, httpContext.getMessage( "extra", "")) == 0 )
      {
         AV16LiqDLog = httpContext.getMessage( ". Aumento de horas extras: ", "") + GXutil.trim( GXutil.str( AV15porUnaje, 6, 4)) + httpContext.getMessage( " definido por ", "") + GXutil.trim( AV34definido) ;
      }
      else
      {
         AV16LiqDLog = httpContext.getMessage( ". Recargo a hora normal diurna: ", "") + GXutil.trim( GXutil.str( AV15porUnaje, 6, 4)) + httpContext.getMessage( " definido por ", "") + GXutil.trim( AV34definido) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV16LiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = extra.this.AV15porUnaje;
      this.aP9[0] = extra.this.AV16LiqDLog;
      this.aP10[0] = extra.this.AV34definido;
      this.aP11[0] = extra.this.AV40error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15porUnaje = DecimalUtil.ZERO ;
      AV16LiqDLog = "" ;
      AV34definido = "" ;
      AV40error = "" ;
      AV11LegConveCodigo = "" ;
      GXv_char1 = new String[1] ;
      AV30tipo_trabajo = "" ;
      AV43Pgmname = "" ;
      AV8determina_extra = "" ;
      GXv_int2 = new int[1] ;
      scmdbuf = "" ;
      A1329ConveHsPDiaDesde = "" ;
      A1565CliConvenio = "" ;
      A1326ConvHsPDiaTipTra = "" ;
      P01CE2_A1329ConveHsPDiaDesde = new String[] {""} ;
      P01CE2_n1329ConveHsPDiaDesde = new boolean[] {false} ;
      P01CE2_A1328ConveHsPDiaDia = new byte[1] ;
      P01CE2_A1326ConvHsPDiaTipTra = new String[] {""} ;
      P01CE2_A1565CliConvenio = new String[] {""} ;
      P01CE2_A1564CliPaiConve = new short[1] ;
      P01CE2_A3CliCod = new int[1] ;
      P01CE2_A1330ConveTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CE2_A1350ConveTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CE2_A1327ConveHsExSec = new short[1] ;
      A1330ConveTarifaPDia = DecimalUtil.ZERO ;
      A1350ConveTarifaPDRec = DecimalUtil.ZERO ;
      A1342EmpHsPDiaDesde = "" ;
      A1339EmpHsPDiaTipTra = "" ;
      P01CE3_A1342EmpHsPDiaDesde = new String[] {""} ;
      P01CE3_n1342EmpHsPDiaDesde = new boolean[] {false} ;
      P01CE3_A1341EmpHsPDiaDia = new byte[1] ;
      P01CE3_A1339EmpHsPDiaTipTra = new String[] {""} ;
      P01CE3_A1EmpCod = new short[1] ;
      P01CE3_A3CliCod = new int[1] ;
      P01CE3_A1343EmpTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CE3_A1351EmpTarfaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01CE3_A1340EmpHsExSec = new short[1] ;
      A1343EmpTarifaPDia = DecimalUtil.ZERO ;
      A1351EmpTarfaPDRec = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.extra__default(),
         new Object[] {
             new Object[] {
            P01CE2_A1329ConveHsPDiaDesde, P01CE2_n1329ConveHsPDiaDesde, P01CE2_A1328ConveHsPDiaDia, P01CE2_A1326ConvHsPDiaTipTra, P01CE2_A1565CliConvenio, P01CE2_A1564CliPaiConve, P01CE2_A3CliCod, P01CE2_A1330ConveTarifaPDia, P01CE2_A1350ConveTarifaPDRec, P01CE2_A1327ConveHsExSec
            }
            , new Object[] {
            P01CE3_A1342EmpHsPDiaDesde, P01CE3_n1342EmpHsPDiaDesde, P01CE3_A1341EmpHsPDiaDia, P01CE3_A1339EmpHsPDiaTipTra, P01CE3_A1EmpCod, P01CE3_A3CliCod, P01CE3_A1343EmpTarifaPDia, P01CE3_A1351EmpTarfaPDRec, P01CE3_A1340EmpHsExSec
            }
         }
      );
      AV43Pgmname = "extra" ;
      /* GeneXus formulas. */
      AV43Pgmname = "extra" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18dia_tra ;
   private byte A1328ConveHsPDiaDia ;
   private byte A1341EmpHsPDiaDia ;
   private short AV21EmpCod ;
   private short AV12PaiCod ;
   private short A1564CliPaiConve ;
   private short A1327ConveHsExSec ;
   private short A1EmpCod ;
   private short A1340EmpHsExSec ;
   private short Gx_err ;
   private int AV26CliCod ;
   private int AV28LegNumero ;
   private int AV36CliConveVer ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private java.math.BigDecimal AV15porUnaje ;
   private java.math.BigDecimal A1330ConveTarifaPDia ;
   private java.math.BigDecimal A1350ConveTarifaPDRec ;
   private java.math.BigDecimal A1343EmpTarifaPDia ;
   private java.math.BigDecimal A1351EmpTarfaPDRec ;
   private String AV33tipoTrabajoPalabra ;
   private String AV31diaPalabra ;
   private String AV19horaDesde ;
   private String AV29busca ;
   private String AV11LegConveCodigo ;
   private String GXv_char1[] ;
   private String AV30tipo_trabajo ;
   private String AV43Pgmname ;
   private String AV8determina_extra ;
   private String scmdbuf ;
   private String A1329ConveHsPDiaDesde ;
   private String A1565CliConvenio ;
   private String A1326ConvHsPDiaTipTra ;
   private String A1342EmpHsPDiaDesde ;
   private String A1339EmpHsPDiaTipTra ;
   private boolean returnInSub ;
   private boolean n1329ConveHsPDiaDesde ;
   private boolean n1342EmpHsPDiaDesde ;
   private String AV16LiqDLog ;
   private String AV34definido ;
   private String AV40error ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private String[] P01CE2_A1329ConveHsPDiaDesde ;
   private boolean[] P01CE2_n1329ConveHsPDiaDesde ;
   private byte[] P01CE2_A1328ConveHsPDiaDia ;
   private String[] P01CE2_A1326ConvHsPDiaTipTra ;
   private String[] P01CE2_A1565CliConvenio ;
   private short[] P01CE2_A1564CliPaiConve ;
   private int[] P01CE2_A3CliCod ;
   private java.math.BigDecimal[] P01CE2_A1330ConveTarifaPDia ;
   private java.math.BigDecimal[] P01CE2_A1350ConveTarifaPDRec ;
   private short[] P01CE2_A1327ConveHsExSec ;
   private String[] P01CE3_A1342EmpHsPDiaDesde ;
   private boolean[] P01CE3_n1342EmpHsPDiaDesde ;
   private byte[] P01CE3_A1341EmpHsPDiaDia ;
   private String[] P01CE3_A1339EmpHsPDiaTipTra ;
   private short[] P01CE3_A1EmpCod ;
   private int[] P01CE3_A3CliCod ;
   private java.math.BigDecimal[] P01CE3_A1343EmpTarifaPDia ;
   private java.math.BigDecimal[] P01CE3_A1351EmpTarfaPDRec ;
   private short[] P01CE3_A1340EmpHsExSec ;
}

final  class extra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01CE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV19horaDesde ,
                                          String A1329ConveHsPDiaDesde ,
                                          byte A1328ConveHsPDiaDia ,
                                          byte AV18dia_tra ,
                                          int AV36CliConveVer ,
                                          short AV12PaiCod ,
                                          String AV11LegConveCodigo ,
                                          String AV30tipo_trabajo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio ,
                                          String A1326ConvHsPDiaTipTra )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[6];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT ConveHsPDiaDesde, ConveHsPDiaDia, ConvHsPDiaTipTra, CliConvenio, CliPaiConve, CliCod, ConveTarifaPDia, ConveTarifaPDRec, ConveHsExSec FROM Convenio_horasextras_porDia" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConvHsPDiaTipTra = ( ?))");
      addWhere(sWhereString, "(ConveHsPDiaDia = ?)");
      if ( ! (GXutil.strcmp("", AV19horaDesde)==0) )
      {
         addWhere(sWhereString, "(ConveHsPDiaDesde >= ( ?))");
      }
      else
      {
         GXv_int3[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConvHsPDiaTipTra" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   protected Object[] conditional_P01CE3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV19horaDesde ,
                                          String A1342EmpHsPDiaDesde ,
                                          byte A1341EmpHsPDiaDia ,
                                          byte AV18dia_tra ,
                                          int AV26CliCod ,
                                          short AV21EmpCod ,
                                          String AV30tipo_trabajo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          String A1339EmpHsPDiaTipTra )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[5];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT EmpHsPDiaDesde, EmpHsPDiaDia, EmpHsPDiaTipTra, EmpCod, CliCod, EmpTarifaPDia, EmpTarfaPDRec, EmpHsExSec FROM Empresahorasextras_pordia" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and EmpHsPDiaTipTra = ( ?))");
      addWhere(sWhereString, "(EmpHsPDiaDia = ?)");
      if ( ! (GXutil.strcmp("", AV19horaDesde)==0) )
      {
         addWhere(sWhereString, "(EmpHsPDiaDesde >= ( ?))");
      }
      else
      {
         GXv_int5[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, EmpHsPDiaTipTra" ;
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
            case 0 :
                  return conditional_P01CE2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , (String)dynConstraints[11] );
            case 1 :
                  return conditional_P01CE3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).byteValue() , ((Number) dynConstraints[3]).byteValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , (String)dynConstraints[9] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01CE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01CE3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 5);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,4);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 5);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,4);
               ((short[]) buf[8])[0] = rslt.getShort(8);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[8], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[10]).byteValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 5);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[8]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 5);
               }
               return;
      }
   }

}

