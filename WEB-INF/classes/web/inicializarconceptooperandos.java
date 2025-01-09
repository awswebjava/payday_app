package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarconceptooperandos extends GXProcedure
{
   public inicializarconceptooperandos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarconceptooperandos.class ), "" );
   }

   public inicializarconceptooperandos( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      inicializarconceptooperandos.this.AV13CliCod = aP0;
      inicializarconceptooperandos.this.AV19parmConCodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      GXv_char1[0] = AV21conceptoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV13CliCod, "{concepto}", false, true, GXv_char1) ;
      inicializarconceptooperandos.this.AV21conceptoPalabra = GXv_char1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&clicod = ", "")+GXutil.str( AV13CliCod, 6, 0)) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV19parmConCodigo ,
                                           A26ConCodigo ,
                                           A148ConFormula ,
                                           Integer.valueOf(AV13CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P00ZW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), AV19parmConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A148ConFormula = P00ZW2_A148ConFormula[0] ;
         n148ConFormula = P00ZW2_n148ConFormula[0] ;
         A26ConCodigo = P00ZW2_A26ConCodigo[0] ;
         A3CliCod = P00ZW2_A3CliCod[0] ;
         W3CliCod = A3CliCod ;
         AV9ConCodigo = A26ConCodigo ;
         GXt_objcol_SdtSDTOperandosFormula2 = AV8SDTOperandos ;
         GXv_objcol_SdtSDTOperandosFormula3[0] = GXt_objcol_SdtSDTOperandosFormula2 ;
         new web.obtoperandosformula(remoteHandle, context).execute( AV13CliCod, A26ConCodigo, A148ConFormula, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_objcol_SdtSDTOperandosFormula3) ;
         GXt_objcol_SdtSDTOperandosFormula2 = GXv_objcol_SdtSDTOperandosFormula3[0] ;
         AV8SDTOperandos = GXt_objcol_SdtSDTOperandosFormula2 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " ConFormula ", "")+GXutil.trim( A148ConFormula)+httpContext.getMessage( " &SDTOperandos count ", "")+GXutil.trim( GXutil.str( AV8SDTOperandos.size(), 9, 0))) ;
         /* Execute user subroutine: 'OPERANDOS' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV38GXV1 = 1 ;
         while ( AV38GXV1 <= AV8SDTOperandos.size() )
         {
            AV12SDTOperandosItem = (web.SdtSDTOperandosFormula)((web.SdtSDTOperandosFormula)AV8SDTOperandos.elementAt(-1+AV38GXV1));
            AV29idOperando = "" ;
            GXv_char1[0] = AV32Operando ;
            GXv_char4[0] = AV15primeraPalabra ;
            new web.opeformulaapalabramayuscula(remoteHandle, context).execute( AV12SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal(), GXv_char1, GXv_char4) ;
            inicializarconceptooperandos.this.AV32Operando = GXv_char1[0] ;
            inicializarconceptooperandos.this.AV15primeraPalabra = GXv_char4[0] ;
            GXv_char4[0] = "" ;
            GXv_char1[0] = "" ;
            GXv_boolean5[0] = AV26ConOpeCantEs ;
            GXv_char6[0] = "" ;
            GXv_char7[0] = "" ;
            GXv_char8[0] = AV29idOperando ;
            GXv_char9[0] = AV31OpeCliId ;
            GXv_boolean10[0] = false ;
            GXv_char11[0] = AV33OperandoTipo ;
            GXv_char12[0] = "" ;
            GXv_boolean13[0] = AV25ConOpeAliEs ;
            GXv_char14[0] = AV23error ;
            new web.clasificaroperando(remoteHandle, context).execute( AV13CliCod, 0, A26ConCodigo, AV32Operando, AV15primeraPalabra, AV28fecha, false, GXv_char4, GXv_char1, GXv_boolean5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_boolean10, GXv_char11, GXv_char12, GXv_boolean13, GXv_char14) ;
            inicializarconceptooperandos.this.AV26ConOpeCantEs = GXv_boolean5[0] ;
            inicializarconceptooperandos.this.AV29idOperando = GXv_char8[0] ;
            inicializarconceptooperandos.this.AV31OpeCliId = GXv_char9[0] ;
            inicializarconceptooperandos.this.AV33OperandoTipo = GXv_char11[0] ;
            inicializarconceptooperandos.this.AV25ConOpeAliEs = GXv_boolean13[0] ;
            inicializarconceptooperandos.this.AV23error = GXv_char14[0] ;
            if ( ! (GXutil.strcmp("", AV23error)==0) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "error ", "")+AV23error) ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "!! &Operando ", "")+GXutil.trim( AV32Operando)+httpContext.getMessage( " &idOperando ", "")+AV29idOperando) ;
               AV27ConOpeId = "" ;
               if ( ! (GXutil.strcmp("", AV29idOperando)==0) )
               {
                  AV27ConOpeId = GXutil.trim( AV29idOperando) ;
               }
               else
               {
                  if ( ! (GXutil.strcmp("", AV31OpeCliId)==0) )
                  {
                     AV27ConOpeId = GXutil.trim( AV31OpeCliId) ;
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(httpContext.getMessage( "Error no identificó operando", ""));
                  }
               }
               if ( ! (GXutil.strcmp("", AV27ConOpeId)==0) )
               {
                  if ( ! (GXutil.strcmp("", AV29idOperando)==0) )
                  {
                     GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem15[0] = AV24cal_par_valores ;
                     GXv_char14[0] = AV23error ;
                     new web.devuelveparametroscc4(remoteHandle, context).execute( AV13CliCod, AV29idOperando, AV32Operando, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem15, GXv_char14) ;
                     AV24cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem15[0] ;
                     inicializarconceptooperandos.this.AV23error = GXv_char14[0] ;
                  }
                  else
                  {
                     AV24cal_par_valores.clear();
                  }
                  /*
                     INSERT RECORD ON TABLE concepto_operandos

                  */
                  W3CliCod = A3CliCod ;
                  W26ConCodigo = A26ConCodigo ;
                  A3CliCod = AV13CliCod ;
                  A26ConCodigo = AV9ConCodigo ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "cabecera ", "")+AV32Operando) ;
                  A923ConOperFor = AV32Operando ;
                  A2119ConOpeId = AV27ConOpeId ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "new ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " concodigo ", "")+GXutil.trim( AV9ConCodigo)+httpContext.getMessage( " SDTOperandosItem.OperandoOriginal.Trim() ", "")+GXutil.trim( AV12SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal())+httpContext.getMessage( "&conceptoPalabra ", "")+AV21conceptoPalabra) ;
                  A2118ConOpeParError = GXutil.trim( AV23error) ;
                  A2121ConOpeCantEs = AV26ConOpeCantEs ;
                  A2122ConOpeAliEs = AV25ConOpeAliEs ;
                  A2126ConOpeOrig = GXutil.trim( AV12SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal()) ;
                  A2127ConOpeDesc = "" ;
                  /* Using cursor P00ZW3 */
                  pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A2119ConOpeId, A923ConOperFor, A2118ConOpeParError, Boolean.valueOf(A2121ConOpeCantEs), Boolean.valueOf(A2122ConOpeAliEs), A2126ConOpeOrig, A2127ConOpeDesc});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("concepto_operandos");
                  if ( (pr_default.getStatus(1) == 1) )
                  {
                     Gx_err = (short)(1) ;
                     Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                  }
                  else
                  {
                     Gx_err = (short)(0) ;
                     Gx_emsg = "" ;
                  }
                  A3CliCod = W3CliCod ;
                  A26ConCodigo = W26ConCodigo ;
                  /* End Insert */
                  AV39GXV2 = 1 ;
                  while ( AV39GXV2 <= AV24cal_par_valores.size() )
                  {
                     AV30item = (web.Sdtcal_par_valores_cal_par_valoresItem)((web.Sdtcal_par_valores_cal_par_valoresItem)AV24cal_par_valores.elementAt(-1+AV39GXV2));
                     new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "tablita ", "")+AV32Operando) ;
                     /*
                        INSERT RECORD ON TABLE concepto_operandosParametros

                     */
                     W3CliCod = A3CliCod ;
                     W26ConCodigo = A26ConCodigo ;
                     A3CliCod = AV13CliCod ;
                     A26ConCodigo = AV9ConCodigo ;
                     A2119ConOpeId = AV27ConOpeId ;
                     A923ConOperFor = AV32Operando ;
                     A2116ConOpeParId = AV30item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Calparid() ;
                     A2117ConOpeParValor = AV30item.getgxTv_Sdtcal_par_valores_cal_par_valoresItem_Value() ;
                     /* Using cursor P00ZW4 */
                     pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A2119ConOpeId, A923ConOperFor, A2116ConOpeParId, A2117ConOpeParValor});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("concepto_operandosParametros");
                     if ( (pr_default.getStatus(2) == 1) )
                     {
                        Gx_err = (short)(1) ;
                        Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
                     }
                     else
                     {
                        Gx_err = (short)(0) ;
                        Gx_emsg = "" ;
                     }
                     A3CliCod = W3CliCod ;
                     A26ConCodigo = W26ConCodigo ;
                     /* End Insert */
                     AV39GXV2 = (int)(AV39GXV2+1) ;
                  }
               }
            }
            AV38GXV1 = (int)(AV38GXV1+1) ;
         }
         A3CliCod = W3CliCod ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'OPERANDOS' Routine */
      returnInSub = false ;
      /* Using cursor P00ZW5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV13CliCod), AV9ConCodigo});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A923ConOperFor = P00ZW5_A923ConOperFor[0] ;
         A2119ConOpeId = P00ZW5_A2119ConOpeId[0] ;
         A26ConCodigo = P00ZW5_A26ConCodigo[0] ;
         A3CliCod = P00ZW5_A3CliCod[0] ;
         A2121ConOpeCantEs = P00ZW5_A2121ConOpeCantEs[0] ;
         /* Optimized DELETE. */
         /* Using cursor P00ZW6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A2119ConOpeId, A923ConOperFor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("concepto_operandosParametros");
         /* End optimized DELETE. */
         /* Using cursor P00ZW7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A26ConCodigo, A2119ConOpeId, A923ConOperFor});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("concepto_operandos");
         pr_default.readNext(3);
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarconceptooperandos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV36Pgmname = "" ;
      AV21conceptoPalabra = "" ;
      scmdbuf = "" ;
      A26ConCodigo = "" ;
      A148ConFormula = "" ;
      P00ZW2_A148ConFormula = new String[] {""} ;
      P00ZW2_n148ConFormula = new boolean[] {false} ;
      P00ZW2_A26ConCodigo = new String[] {""} ;
      P00ZW2_A3CliCod = new int[1] ;
      AV9ConCodigo = "" ;
      AV8SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXt_objcol_SdtSDTOperandosFormula2 = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXv_objcol_SdtSDTOperandosFormula3 = new GXBaseCollection[1] ;
      AV12SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV29idOperando = "" ;
      AV32Operando = "" ;
      AV15primeraPalabra = "" ;
      AV28fecha = GXutil.nullDate() ;
      GXv_char4 = new String[1] ;
      GXv_char1 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXv_char8 = new String[1] ;
      AV31OpeCliId = "" ;
      GXv_char9 = new String[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV33OperandoTipo = "" ;
      GXv_char11 = new String[1] ;
      GXv_char12 = new String[1] ;
      GXv_boolean13 = new boolean[1] ;
      AV23error = "" ;
      AV27ConOpeId = "" ;
      AV24cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem15 = new GXBaseCollection[1] ;
      GXv_char14 = new String[1] ;
      W26ConCodigo = "" ;
      A923ConOperFor = "" ;
      A2119ConOpeId = "" ;
      A2118ConOpeParError = "" ;
      A2126ConOpeOrig = "" ;
      A2127ConOpeDesc = "" ;
      Gx_emsg = "" ;
      AV30item = new web.Sdtcal_par_valores_cal_par_valoresItem(remoteHandle, context);
      A2116ConOpeParId = "" ;
      A2117ConOpeParValor = "" ;
      P00ZW5_A923ConOperFor = new String[] {""} ;
      P00ZW5_A2119ConOpeId = new String[] {""} ;
      P00ZW5_A26ConCodigo = new String[] {""} ;
      P00ZW5_A3CliCod = new int[1] ;
      P00ZW5_A2121ConOpeCantEs = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarconceptooperandos__default(),
         new Object[] {
             new Object[] {
            P00ZW2_A148ConFormula, P00ZW2_n148ConFormula, P00ZW2_A26ConCodigo, P00ZW2_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P00ZW5_A923ConOperFor, P00ZW5_A2119ConOpeId, P00ZW5_A26ConCodigo, P00ZW5_A3CliCod, P00ZW5_A2121ConOpeCantEs
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV36Pgmname = "inicializarConceptoOperandos" ;
      /* GeneXus formulas. */
      AV36Pgmname = "inicializarConceptoOperandos" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private int W3CliCod ;
   private int AV38GXV1 ;
   private int GX_INS263 ;
   private int AV39GXV2 ;
   private int GX_INS264 ;
   private String AV19parmConCodigo ;
   private String AV36Pgmname ;
   private String AV21conceptoPalabra ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV9ConCodigo ;
   private String AV29idOperando ;
   private String AV15primeraPalabra ;
   private String GXv_char4[] ;
   private String GXv_char1[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String AV31OpeCliId ;
   private String GXv_char9[] ;
   private String AV33OperandoTipo ;
   private String GXv_char11[] ;
   private String GXv_char12[] ;
   private String AV27ConOpeId ;
   private String GXv_char14[] ;
   private String W26ConCodigo ;
   private String A2119ConOpeId ;
   private String Gx_emsg ;
   private String A2116ConOpeParId ;
   private java.util.Date AV28fecha ;
   private boolean n148ConFormula ;
   private boolean returnInSub ;
   private boolean AV26ConOpeCantEs ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean10[] ;
   private boolean AV25ConOpeAliEs ;
   private boolean GXv_boolean13[] ;
   private boolean A2121ConOpeCantEs ;
   private boolean A2122ConOpeAliEs ;
   private String A148ConFormula ;
   private String AV32Operando ;
   private String AV23error ;
   private String A923ConOperFor ;
   private String A2118ConOpeParError ;
   private String A2126ConOpeOrig ;
   private String A2127ConOpeDesc ;
   private String A2117ConOpeParValor ;
   private IDataStoreProvider pr_default ;
   private String[] P00ZW2_A148ConFormula ;
   private boolean[] P00ZW2_n148ConFormula ;
   private String[] P00ZW2_A26ConCodigo ;
   private int[] P00ZW2_A3CliCod ;
   private String[] P00ZW5_A923ConOperFor ;
   private String[] P00ZW5_A2119ConOpeId ;
   private String[] P00ZW5_A26ConCodigo ;
   private int[] P00ZW5_A3CliCod ;
   private boolean[] P00ZW5_A2121ConOpeCantEs ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV24cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem15[] ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV8SDTOperandos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXt_objcol_SdtSDTOperandosFormula2 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula3[] ;
   private web.Sdtcal_par_valores_cal_par_valoresItem AV30item ;
   private web.SdtSDTOperandosFormula AV12SDTOperandosItem ;
}

final  class inicializarconceptooperandos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00ZW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV19parmConCodigo ,
                                          String A26ConCodigo ,
                                          String A148ConFormula ,
                                          int AV13CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[2];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT ConFormula, ConCodigo, CliCod FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from ConFormula))=0))");
      if ( ! (GXutil.strcmp("", AV19parmConCodigo)==0) )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int16[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
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
                  return conditional_P00ZW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ZW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00ZW3", "SAVEPOINT gxupdate;INSERT INTO concepto_operandos(CliCod, ConCodigo, ConOpeId, ConOperFor, ConOpeParError, ConOpeCantEs, ConOpeAliEs, ConOpeOrig, ConOpeDesc, ConOpeConCodigo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00ZW4", "SAVEPOINT gxupdate;INSERT INTO concepto_operandosParametros(CliCod, ConCodigo, ConOpeId, ConOperFor, ConOpeParId, ConOpeParValor) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00ZW5", "SELECT ConOperFor, ConOpeId, ConCodigo, CliCod, ConOpeCantEs FROM concepto_operandos WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo  FOR UPDATE OF concepto_operandos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00ZW6", "DELETE FROM concepto_operandosParametros  WHERE CliCod = ? and ConCodigo = ( ?) and ConOpeId = ( ?) and ConOperFor = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00ZW7", "SAVEPOINT gxupdate;DELETE FROM concepto_operandos  WHERE CliCod = ? AND ConCodigo = ? AND ConOpeId = ? AND ConOperFor = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 10);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setVarchar(8, (String)parms[7], 100, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setVarchar(6, (String)parms[5], 100, false);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 100, false);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setVarchar(4, (String)parms[3], 100, false);
               return;
      }
   }

}

