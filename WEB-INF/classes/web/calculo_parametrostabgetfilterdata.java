package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculo_parametrostabgetfilterdata extends GXProcedure
{
   public calculo_parametrostabgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_parametrostabgetfilterdata.class ), "" );
   }

   public calculo_parametrostabgetfilterdata( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      calculo_parametrostabgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      calculo_parametrostabgetfilterdata.this.AV49DDOName = aP0;
      calculo_parametrostabgetfilterdata.this.AV50SearchTxt = aP1;
      calculo_parametrostabgetfilterdata.this.AV51SearchTxtTo = aP2;
      calculo_parametrostabgetfilterdata.this.aP3 = aP3;
      calculo_parametrostabgetfilterdata.this.aP4 = aP4;
      calculo_parametrostabgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV39Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV41OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV42OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando", GXv_boolean2) ;
      calculo_parametrostabgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPARNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPARNOMBREOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPARDESC") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPARDESCOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPARCAMPO") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPARCAMPOOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPARVALLISTA") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPARVALLISTAOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPARDEF") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPARDEFOPTIONS' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPAREJEMPLO") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPAREJEMPLOOPTIONS' */
            S171 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV49DDOName), "DDO_CALPAREJEMEXPLI") == 0 )
         {
            /* Execute user subroutine: 'LOADCALPAREJEMEXPLIOPTIONS' */
            S181 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV52OptionsJson = AV39Options.toJSonString(false) ;
      AV53OptionsDescJson = AV41OptionsDesc.toJSonString(false) ;
      AV54OptionIndexesJson = AV42OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV44Session.getValue("Calculo_parametrosTabGridState"), "") == 0 )
      {
         AV46GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "Calculo_parametrosTabGridState"), null, null);
      }
      else
      {
         AV46GridState.fromxml(AV44Session.getValue("Calculo_parametrosTabGridState"), null, null);
      }
      AV61GXV1 = 1 ;
      while ( AV61GXV1 <= AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV47GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV46GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV61GXV1));
         if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARNOMBRE") == 0 )
         {
            AV12TFCalParNombre = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARNOMBRE_SEL") == 0 )
         {
            AV11TFCalParNombre_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFCalParNombre_Sels.fromJSonString(AV11TFCalParNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDESC") == 0 )
         {
            AV15TFCalParDesc = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDESC_SEL") == 0 )
         {
            AV14TFCalParDesc_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFCalParDesc_Sels.fromJSonString(AV14TFCalParDesc_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARCAMPO") == 0 )
         {
            AV18TFCalParCampo = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARCAMPO_SEL") == 0 )
         {
            AV17TFCalParCampo_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFCalParCampo_Sels.fromJSonString(AV17TFCalParCampo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARVALLISTA") == 0 )
         {
            AV21TFCalParValLista = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARVALLISTA_SEL") == 0 )
         {
            AV20TFCalParValLista_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV22TFCalParValLista_Sels.fromJSonString(AV20TFCalParValLista_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDEF") == 0 )
         {
            AV24TFCalParDef = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARDEF_SEL") == 0 )
         {
            AV23TFCalParDef_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV25TFCalParDef_Sels.fromJSonString(AV23TFCalParDef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAROBL_SEL") == 0 )
         {
            AV26TFCalParObl_Sel = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARGRP") == 0 )
         {
            AV27TFCalParGrp = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV28TFCalParGrp_To = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPARGRPDEP") == 0 )
         {
            AV29TFCalParGrpDep = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV30TFCalParGrpDep_To = (byte)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMPLO") == 0 )
         {
            AV32TFCalParEjemplo = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMPLO_SEL") == 0 )
         {
            AV31TFCalParEjemplo_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV33TFCalParEjemplo_Sels.fromJSonString(AV31TFCalParEjemplo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMEXPLI") == 0 )
         {
            AV35TFCalParEjemExpli = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCALPAREJEMEXPLI_SEL") == 0 )
         {
            AV34TFCalParEjemExpli_SelsJson = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFCalParEjemExpli_Sels.fromJSonString(AV34TFCalParEjemExpli_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&PAICOD") == 0 )
         {
            AV55PaiCod = (short)(GXutil.lval( AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&IDOPERANDO") == 0 )
         {
            AV56idOperando = AV47GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV61GXV1 = (int)(AV61GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCALPARNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV12TFCalParNombre = AV50SearchTxt ;
      AV13TFCalParNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk20L2 = false ;
         A46PaiCod = P020L2_A46PaiCod[0] ;
         A74idOperando = P020L2_A74idOperando[0] ;
         A2110CalParNombre = P020L2_A2110CalParNombre[0] ;
         A2109CalParEjemExpli = P020L2_A2109CalParEjemExpli[0] ;
         A2108CalParEjemplo = P020L2_A2108CalParEjemplo[0] ;
         A2105CalParGrpDep = P020L2_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L2_A2104CalParGrp[0] ;
         A2106CalParObl = P020L2_A2106CalParObl[0] ;
         A2107CalParDef = P020L2_A2107CalParDef[0] ;
         A2111CalParValLista = P020L2_A2111CalParValLista[0] ;
         A2099CalParCampo = P020L2_A2099CalParCampo[0] ;
         A2100CalParDesc = P020L2_A2100CalParDesc[0] ;
         A2098CalParId = P020L2_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P020L2_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L2_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L2_A2110CalParNombre[0], A2110CalParNombre) == 0 ) )
         {
            brk20L2 = false ;
            A2098CalParId = P020L2_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A2110CalParNombre)==0) )
         {
            AV38Option = A2110CalParNombre ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L2 )
         {
            brk20L2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCALPARDESCOPTIONS' Routine */
      returnInSub = false ;
      AV15TFCalParDesc = AV50SearchTxt ;
      AV16TFCalParDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk20L4 = false ;
         A46PaiCod = P020L3_A46PaiCod[0] ;
         A74idOperando = P020L3_A74idOperando[0] ;
         A2100CalParDesc = P020L3_A2100CalParDesc[0] ;
         A2109CalParEjemExpli = P020L3_A2109CalParEjemExpli[0] ;
         A2108CalParEjemplo = P020L3_A2108CalParEjemplo[0] ;
         A2105CalParGrpDep = P020L3_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L3_A2104CalParGrp[0] ;
         A2106CalParObl = P020L3_A2106CalParObl[0] ;
         A2107CalParDef = P020L3_A2107CalParDef[0] ;
         A2111CalParValLista = P020L3_A2111CalParValLista[0] ;
         A2099CalParCampo = P020L3_A2099CalParCampo[0] ;
         A2110CalParNombre = P020L3_A2110CalParNombre[0] ;
         A2098CalParId = P020L3_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P020L3_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L3_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L3_A2100CalParDesc[0], A2100CalParDesc) == 0 ) )
         {
            brk20L4 = false ;
            A2098CalParId = P020L3_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A2100CalParDesc)==0) )
         {
            AV38Option = A2100CalParDesc ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L4 )
         {
            brk20L4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCALPARCAMPOOPTIONS' Routine */
      returnInSub = false ;
      AV18TFCalParCampo = AV50SearchTxt ;
      AV19TFCalParCampo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L4 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk20L6 = false ;
         A46PaiCod = P020L4_A46PaiCod[0] ;
         A74idOperando = P020L4_A74idOperando[0] ;
         A2099CalParCampo = P020L4_A2099CalParCampo[0] ;
         A2109CalParEjemExpli = P020L4_A2109CalParEjemExpli[0] ;
         A2108CalParEjemplo = P020L4_A2108CalParEjemplo[0] ;
         A2105CalParGrpDep = P020L4_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L4_A2104CalParGrp[0] ;
         A2106CalParObl = P020L4_A2106CalParObl[0] ;
         A2107CalParDef = P020L4_A2107CalParDef[0] ;
         A2111CalParValLista = P020L4_A2111CalParValLista[0] ;
         A2100CalParDesc = P020L4_A2100CalParDesc[0] ;
         A2110CalParNombre = P020L4_A2110CalParNombre[0] ;
         A2098CalParId = P020L4_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( P020L4_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L4_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L4_A2099CalParCampo[0], A2099CalParCampo) == 0 ) )
         {
            brk20L6 = false ;
            A2098CalParId = P020L4_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2099CalParCampo)==0) )
         {
            AV38Option = A2099CalParCampo ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L6 )
         {
            brk20L6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADCALPARVALLISTAOPTIONS' Routine */
      returnInSub = false ;
      AV21TFCalParValLista = AV50SearchTxt ;
      AV22TFCalParValLista_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L5 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk20L8 = false ;
         A46PaiCod = P020L5_A46PaiCod[0] ;
         A74idOperando = P020L5_A74idOperando[0] ;
         A2111CalParValLista = P020L5_A2111CalParValLista[0] ;
         A2109CalParEjemExpli = P020L5_A2109CalParEjemExpli[0] ;
         A2108CalParEjemplo = P020L5_A2108CalParEjemplo[0] ;
         A2105CalParGrpDep = P020L5_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L5_A2104CalParGrp[0] ;
         A2106CalParObl = P020L5_A2106CalParObl[0] ;
         A2107CalParDef = P020L5_A2107CalParDef[0] ;
         A2099CalParCampo = P020L5_A2099CalParCampo[0] ;
         A2100CalParDesc = P020L5_A2100CalParDesc[0] ;
         A2110CalParNombre = P020L5_A2110CalParNombre[0] ;
         A2098CalParId = P020L5_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( P020L5_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L5_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L5_A2111CalParValLista[0], A2111CalParValLista) == 0 ) )
         {
            brk20L8 = false ;
            A2098CalParId = P020L5_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A2111CalParValLista)==0) )
         {
            AV38Option = A2111CalParValLista ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L8 )
         {
            brk20L8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   public void S161( )
   {
      /* 'LOADCALPARDEFOPTIONS' Routine */
      returnInSub = false ;
      AV24TFCalParDef = AV50SearchTxt ;
      AV25TFCalParDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L6 */
      pr_default.execute(4, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(4) != 101) )
      {
         brk20L10 = false ;
         A46PaiCod = P020L6_A46PaiCod[0] ;
         A74idOperando = P020L6_A74idOperando[0] ;
         A2107CalParDef = P020L6_A2107CalParDef[0] ;
         A2109CalParEjemExpli = P020L6_A2109CalParEjemExpli[0] ;
         A2108CalParEjemplo = P020L6_A2108CalParEjemplo[0] ;
         A2105CalParGrpDep = P020L6_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L6_A2104CalParGrp[0] ;
         A2106CalParObl = P020L6_A2106CalParObl[0] ;
         A2111CalParValLista = P020L6_A2111CalParValLista[0] ;
         A2099CalParCampo = P020L6_A2099CalParCampo[0] ;
         A2100CalParDesc = P020L6_A2100CalParDesc[0] ;
         A2110CalParNombre = P020L6_A2110CalParNombre[0] ;
         A2098CalParId = P020L6_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(4) != 101) && ( P020L6_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L6_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L6_A2107CalParDef[0], A2107CalParDef) == 0 ) )
         {
            brk20L10 = false ;
            A2098CalParId = P020L6_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L10 = true ;
            pr_default.readNext(4);
         }
         if ( ! (GXutil.strcmp("", A2107CalParDef)==0) )
         {
            AV38Option = A2107CalParDef ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L10 )
         {
            brk20L10 = true ;
            pr_default.readNext(4);
         }
      }
      pr_default.close(4);
   }

   public void S171( )
   {
      /* 'LOADCALPAREJEMPLOOPTIONS' Routine */
      returnInSub = false ;
      AV32TFCalParEjemplo = AV50SearchTxt ;
      AV33TFCalParEjemplo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(5, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L7 */
      pr_default.execute(5, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(5) != 101) )
      {
         brk20L12 = false ;
         A46PaiCod = P020L7_A46PaiCod[0] ;
         A74idOperando = P020L7_A74idOperando[0] ;
         A2108CalParEjemplo = P020L7_A2108CalParEjemplo[0] ;
         A2109CalParEjemExpli = P020L7_A2109CalParEjemExpli[0] ;
         A2105CalParGrpDep = P020L7_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L7_A2104CalParGrp[0] ;
         A2106CalParObl = P020L7_A2106CalParObl[0] ;
         A2107CalParDef = P020L7_A2107CalParDef[0] ;
         A2111CalParValLista = P020L7_A2111CalParValLista[0] ;
         A2099CalParCampo = P020L7_A2099CalParCampo[0] ;
         A2100CalParDesc = P020L7_A2100CalParDesc[0] ;
         A2110CalParNombre = P020L7_A2110CalParNombre[0] ;
         A2098CalParId = P020L7_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(5) != 101) && ( P020L7_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L7_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L7_A2108CalParEjemplo[0], A2108CalParEjemplo) == 0 ) )
         {
            brk20L12 = false ;
            A2098CalParId = P020L7_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L12 = true ;
            pr_default.readNext(5);
         }
         if ( ! (GXutil.strcmp("", A2108CalParEjemplo)==0) )
         {
            AV38Option = A2108CalParEjemplo ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L12 )
         {
            brk20L12 = true ;
            pr_default.readNext(5);
         }
      }
      pr_default.close(5);
   }

   public void S181( )
   {
      /* 'LOADCALPAREJEMEXPLIOPTIONS' Routine */
      returnInSub = false ;
      AV35TFCalParEjemExpli = AV50SearchTxt ;
      AV36TFCalParEjemExpli_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           A2110CalParNombre ,
                                           AV13TFCalParNombre_Sels ,
                                           A2100CalParDesc ,
                                           AV16TFCalParDesc_Sels ,
                                           A2099CalParCampo ,
                                           AV19TFCalParCampo_Sels ,
                                           A2111CalParValLista ,
                                           AV22TFCalParValLista_Sels ,
                                           A2107CalParDef ,
                                           AV25TFCalParDef_Sels ,
                                           A2108CalParEjemplo ,
                                           AV33TFCalParEjemplo_Sels ,
                                           A2109CalParEjemExpli ,
                                           AV36TFCalParEjemExpli_Sels ,
                                           Integer.valueOf(AV13TFCalParNombre_Sels.size()) ,
                                           AV12TFCalParNombre ,
                                           Integer.valueOf(AV16TFCalParDesc_Sels.size()) ,
                                           AV15TFCalParDesc ,
                                           Integer.valueOf(AV19TFCalParCampo_Sels.size()) ,
                                           AV18TFCalParCampo ,
                                           Integer.valueOf(AV22TFCalParValLista_Sels.size()) ,
                                           AV21TFCalParValLista ,
                                           Integer.valueOf(AV25TFCalParDef_Sels.size()) ,
                                           AV24TFCalParDef ,
                                           Byte.valueOf(AV26TFCalParObl_Sel) ,
                                           Byte.valueOf(AV27TFCalParGrp) ,
                                           Byte.valueOf(AV28TFCalParGrp_To) ,
                                           Byte.valueOf(AV29TFCalParGrpDep) ,
                                           Byte.valueOf(AV30TFCalParGrpDep_To) ,
                                           Integer.valueOf(AV33TFCalParEjemplo_Sels.size()) ,
                                           AV32TFCalParEjemplo ,
                                           Integer.valueOf(AV36TFCalParEjemExpli_Sels.size()) ,
                                           AV35TFCalParEjemExpli ,
                                           Boolean.valueOf(A2106CalParObl) ,
                                           Byte.valueOf(A2104CalParGrp) ,
                                           Byte.valueOf(A2105CalParGrpDep) ,
                                           Short.valueOf(AV55PaiCod) ,
                                           AV56idOperando ,
                                           Short.valueOf(A46PaiCod) ,
                                           A74idOperando } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.SHORT,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV12TFCalParNombre = GXutil.concat( GXutil.rtrim( AV12TFCalParNombre), "%", "") ;
      lV15TFCalParDesc = GXutil.concat( GXutil.rtrim( AV15TFCalParDesc), "%", "") ;
      lV18TFCalParCampo = GXutil.concat( GXutil.rtrim( AV18TFCalParCampo), "%", "") ;
      lV21TFCalParValLista = GXutil.concat( GXutil.rtrim( AV21TFCalParValLista), "%", "") ;
      lV24TFCalParDef = GXutil.padr( GXutil.rtrim( AV24TFCalParDef), 20, "%") ;
      lV32TFCalParEjemplo = GXutil.concat( GXutil.rtrim( AV32TFCalParEjemplo), "%", "") ;
      lV35TFCalParEjemExpli = GXutil.concat( GXutil.rtrim( AV35TFCalParEjemExpli), "%", "") ;
      /* Using cursor P020L8 */
      pr_default.execute(6, new Object[] {Short.valueOf(AV55PaiCod), AV56idOperando, lV12TFCalParNombre, lV15TFCalParDesc, lV18TFCalParCampo, lV21TFCalParValLista, lV24TFCalParDef, Byte.valueOf(AV27TFCalParGrp), Byte.valueOf(AV28TFCalParGrp_To), Byte.valueOf(AV29TFCalParGrpDep), Byte.valueOf(AV30TFCalParGrpDep_To), lV32TFCalParEjemplo, lV35TFCalParEjemExpli});
      while ( (pr_default.getStatus(6) != 101) )
      {
         brk20L14 = false ;
         A46PaiCod = P020L8_A46PaiCod[0] ;
         A74idOperando = P020L8_A74idOperando[0] ;
         A2109CalParEjemExpli = P020L8_A2109CalParEjemExpli[0] ;
         A2108CalParEjemplo = P020L8_A2108CalParEjemplo[0] ;
         A2105CalParGrpDep = P020L8_A2105CalParGrpDep[0] ;
         A2104CalParGrp = P020L8_A2104CalParGrp[0] ;
         A2106CalParObl = P020L8_A2106CalParObl[0] ;
         A2107CalParDef = P020L8_A2107CalParDef[0] ;
         A2111CalParValLista = P020L8_A2111CalParValLista[0] ;
         A2099CalParCampo = P020L8_A2099CalParCampo[0] ;
         A2100CalParDesc = P020L8_A2100CalParDesc[0] ;
         A2110CalParNombre = P020L8_A2110CalParNombre[0] ;
         A2098CalParId = P020L8_A2098CalParId[0] ;
         AV43count = 0 ;
         while ( (pr_default.getStatus(6) != 101) && ( P020L8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(P020L8_A74idOperando[0], A74idOperando) == 0 ) && ( GXutil.strcmp(P020L8_A2109CalParEjemExpli[0], A2109CalParEjemExpli) == 0 ) )
         {
            brk20L14 = false ;
            A2098CalParId = P020L8_A2098CalParId[0] ;
            AV43count = (long)(AV43count+1) ;
            brk20L14 = true ;
            pr_default.readNext(6);
         }
         if ( ! (GXutil.strcmp("", A2109CalParEjemExpli)==0) )
         {
            AV38Option = A2109CalParEjemExpli ;
            AV39Options.add(AV38Option, 0);
            AV42OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV43count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV39Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk20L14 )
         {
            brk20L14 = true ;
            pr_default.readNext(6);
         }
      }
      pr_default.close(6);
   }

   protected void cleanup( )
   {
      this.aP3[0] = calculo_parametrostabgetfilterdata.this.AV52OptionsJson;
      this.aP4[0] = calculo_parametrostabgetfilterdata.this.AV53OptionsDescJson;
      this.aP5[0] = calculo_parametrostabgetfilterdata.this.AV54OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV52OptionsJson = "" ;
      AV53OptionsDescJson = "" ;
      AV54OptionIndexesJson = "" ;
      AV39Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV44Session = httpContext.getWebSession();
      AV46GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV47GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFCalParNombre = "" ;
      AV11TFCalParNombre_SelsJson = "" ;
      AV13TFCalParNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFCalParDesc = "" ;
      AV14TFCalParDesc_SelsJson = "" ;
      AV16TFCalParDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFCalParCampo = "" ;
      AV17TFCalParCampo_SelsJson = "" ;
      AV19TFCalParCampo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21TFCalParValLista = "" ;
      AV20TFCalParValLista_SelsJson = "" ;
      AV22TFCalParValLista_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24TFCalParDef = "" ;
      AV23TFCalParDef_SelsJson = "" ;
      AV25TFCalParDef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV32TFCalParEjemplo = "" ;
      AV31TFCalParEjemplo_SelsJson = "" ;
      AV33TFCalParEjemplo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV35TFCalParEjemExpli = "" ;
      AV34TFCalParEjemExpli_SelsJson = "" ;
      AV36TFCalParEjemExpli_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56idOperando = "" ;
      scmdbuf = "" ;
      lV12TFCalParNombre = "" ;
      lV15TFCalParDesc = "" ;
      lV18TFCalParCampo = "" ;
      lV21TFCalParValLista = "" ;
      lV24TFCalParDef = "" ;
      lV32TFCalParEjemplo = "" ;
      lV35TFCalParEjemExpli = "" ;
      A2110CalParNombre = "" ;
      A2100CalParDesc = "" ;
      A2099CalParCampo = "" ;
      A2111CalParValLista = "" ;
      A2107CalParDef = "" ;
      A2108CalParEjemplo = "" ;
      A2109CalParEjemExpli = "" ;
      A74idOperando = "" ;
      P020L2_A46PaiCod = new short[1] ;
      P020L2_A74idOperando = new String[] {""} ;
      P020L2_A2110CalParNombre = new String[] {""} ;
      P020L2_A2109CalParEjemExpli = new String[] {""} ;
      P020L2_A2108CalParEjemplo = new String[] {""} ;
      P020L2_A2105CalParGrpDep = new byte[1] ;
      P020L2_A2104CalParGrp = new byte[1] ;
      P020L2_A2106CalParObl = new boolean[] {false} ;
      P020L2_A2107CalParDef = new String[] {""} ;
      P020L2_A2111CalParValLista = new String[] {""} ;
      P020L2_A2099CalParCampo = new String[] {""} ;
      P020L2_A2100CalParDesc = new String[] {""} ;
      P020L2_A2098CalParId = new String[] {""} ;
      A2098CalParId = "" ;
      AV38Option = "" ;
      P020L3_A46PaiCod = new short[1] ;
      P020L3_A74idOperando = new String[] {""} ;
      P020L3_A2100CalParDesc = new String[] {""} ;
      P020L3_A2109CalParEjemExpli = new String[] {""} ;
      P020L3_A2108CalParEjemplo = new String[] {""} ;
      P020L3_A2105CalParGrpDep = new byte[1] ;
      P020L3_A2104CalParGrp = new byte[1] ;
      P020L3_A2106CalParObl = new boolean[] {false} ;
      P020L3_A2107CalParDef = new String[] {""} ;
      P020L3_A2111CalParValLista = new String[] {""} ;
      P020L3_A2099CalParCampo = new String[] {""} ;
      P020L3_A2110CalParNombre = new String[] {""} ;
      P020L3_A2098CalParId = new String[] {""} ;
      P020L4_A46PaiCod = new short[1] ;
      P020L4_A74idOperando = new String[] {""} ;
      P020L4_A2099CalParCampo = new String[] {""} ;
      P020L4_A2109CalParEjemExpli = new String[] {""} ;
      P020L4_A2108CalParEjemplo = new String[] {""} ;
      P020L4_A2105CalParGrpDep = new byte[1] ;
      P020L4_A2104CalParGrp = new byte[1] ;
      P020L4_A2106CalParObl = new boolean[] {false} ;
      P020L4_A2107CalParDef = new String[] {""} ;
      P020L4_A2111CalParValLista = new String[] {""} ;
      P020L4_A2100CalParDesc = new String[] {""} ;
      P020L4_A2110CalParNombre = new String[] {""} ;
      P020L4_A2098CalParId = new String[] {""} ;
      P020L5_A46PaiCod = new short[1] ;
      P020L5_A74idOperando = new String[] {""} ;
      P020L5_A2111CalParValLista = new String[] {""} ;
      P020L5_A2109CalParEjemExpli = new String[] {""} ;
      P020L5_A2108CalParEjemplo = new String[] {""} ;
      P020L5_A2105CalParGrpDep = new byte[1] ;
      P020L5_A2104CalParGrp = new byte[1] ;
      P020L5_A2106CalParObl = new boolean[] {false} ;
      P020L5_A2107CalParDef = new String[] {""} ;
      P020L5_A2099CalParCampo = new String[] {""} ;
      P020L5_A2100CalParDesc = new String[] {""} ;
      P020L5_A2110CalParNombre = new String[] {""} ;
      P020L5_A2098CalParId = new String[] {""} ;
      P020L6_A46PaiCod = new short[1] ;
      P020L6_A74idOperando = new String[] {""} ;
      P020L6_A2107CalParDef = new String[] {""} ;
      P020L6_A2109CalParEjemExpli = new String[] {""} ;
      P020L6_A2108CalParEjemplo = new String[] {""} ;
      P020L6_A2105CalParGrpDep = new byte[1] ;
      P020L6_A2104CalParGrp = new byte[1] ;
      P020L6_A2106CalParObl = new boolean[] {false} ;
      P020L6_A2111CalParValLista = new String[] {""} ;
      P020L6_A2099CalParCampo = new String[] {""} ;
      P020L6_A2100CalParDesc = new String[] {""} ;
      P020L6_A2110CalParNombre = new String[] {""} ;
      P020L6_A2098CalParId = new String[] {""} ;
      P020L7_A46PaiCod = new short[1] ;
      P020L7_A74idOperando = new String[] {""} ;
      P020L7_A2108CalParEjemplo = new String[] {""} ;
      P020L7_A2109CalParEjemExpli = new String[] {""} ;
      P020L7_A2105CalParGrpDep = new byte[1] ;
      P020L7_A2104CalParGrp = new byte[1] ;
      P020L7_A2106CalParObl = new boolean[] {false} ;
      P020L7_A2107CalParDef = new String[] {""} ;
      P020L7_A2111CalParValLista = new String[] {""} ;
      P020L7_A2099CalParCampo = new String[] {""} ;
      P020L7_A2100CalParDesc = new String[] {""} ;
      P020L7_A2110CalParNombre = new String[] {""} ;
      P020L7_A2098CalParId = new String[] {""} ;
      P020L8_A46PaiCod = new short[1] ;
      P020L8_A74idOperando = new String[] {""} ;
      P020L8_A2109CalParEjemExpli = new String[] {""} ;
      P020L8_A2108CalParEjemplo = new String[] {""} ;
      P020L8_A2105CalParGrpDep = new byte[1] ;
      P020L8_A2104CalParGrp = new byte[1] ;
      P020L8_A2106CalParObl = new boolean[] {false} ;
      P020L8_A2107CalParDef = new String[] {""} ;
      P020L8_A2111CalParValLista = new String[] {""} ;
      P020L8_A2099CalParCampo = new String[] {""} ;
      P020L8_A2100CalParDesc = new String[] {""} ;
      P020L8_A2110CalParNombre = new String[] {""} ;
      P020L8_A2098CalParId = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculo_parametrostabgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P020L2_A46PaiCod, P020L2_A74idOperando, P020L2_A2110CalParNombre, P020L2_A2109CalParEjemExpli, P020L2_A2108CalParEjemplo, P020L2_A2105CalParGrpDep, P020L2_A2104CalParGrp, P020L2_A2106CalParObl, P020L2_A2107CalParDef, P020L2_A2111CalParValLista,
            P020L2_A2099CalParCampo, P020L2_A2100CalParDesc, P020L2_A2098CalParId
            }
            , new Object[] {
            P020L3_A46PaiCod, P020L3_A74idOperando, P020L3_A2100CalParDesc, P020L3_A2109CalParEjemExpli, P020L3_A2108CalParEjemplo, P020L3_A2105CalParGrpDep, P020L3_A2104CalParGrp, P020L3_A2106CalParObl, P020L3_A2107CalParDef, P020L3_A2111CalParValLista,
            P020L3_A2099CalParCampo, P020L3_A2110CalParNombre, P020L3_A2098CalParId
            }
            , new Object[] {
            P020L4_A46PaiCod, P020L4_A74idOperando, P020L4_A2099CalParCampo, P020L4_A2109CalParEjemExpli, P020L4_A2108CalParEjemplo, P020L4_A2105CalParGrpDep, P020L4_A2104CalParGrp, P020L4_A2106CalParObl, P020L4_A2107CalParDef, P020L4_A2111CalParValLista,
            P020L4_A2100CalParDesc, P020L4_A2110CalParNombre, P020L4_A2098CalParId
            }
            , new Object[] {
            P020L5_A46PaiCod, P020L5_A74idOperando, P020L5_A2111CalParValLista, P020L5_A2109CalParEjemExpli, P020L5_A2108CalParEjemplo, P020L5_A2105CalParGrpDep, P020L5_A2104CalParGrp, P020L5_A2106CalParObl, P020L5_A2107CalParDef, P020L5_A2099CalParCampo,
            P020L5_A2100CalParDesc, P020L5_A2110CalParNombre, P020L5_A2098CalParId
            }
            , new Object[] {
            P020L6_A46PaiCod, P020L6_A74idOperando, P020L6_A2107CalParDef, P020L6_A2109CalParEjemExpli, P020L6_A2108CalParEjemplo, P020L6_A2105CalParGrpDep, P020L6_A2104CalParGrp, P020L6_A2106CalParObl, P020L6_A2111CalParValLista, P020L6_A2099CalParCampo,
            P020L6_A2100CalParDesc, P020L6_A2110CalParNombre, P020L6_A2098CalParId
            }
            , new Object[] {
            P020L7_A46PaiCod, P020L7_A74idOperando, P020L7_A2108CalParEjemplo, P020L7_A2109CalParEjemExpli, P020L7_A2105CalParGrpDep, P020L7_A2104CalParGrp, P020L7_A2106CalParObl, P020L7_A2107CalParDef, P020L7_A2111CalParValLista, P020L7_A2099CalParCampo,
            P020L7_A2100CalParDesc, P020L7_A2110CalParNombre, P020L7_A2098CalParId
            }
            , new Object[] {
            P020L8_A46PaiCod, P020L8_A74idOperando, P020L8_A2109CalParEjemExpli, P020L8_A2108CalParEjemplo, P020L8_A2105CalParGrpDep, P020L8_A2104CalParGrp, P020L8_A2106CalParObl, P020L8_A2107CalParDef, P020L8_A2111CalParValLista, P020L8_A2099CalParCampo,
            P020L8_A2100CalParDesc, P020L8_A2110CalParNombre, P020L8_A2098CalParId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV26TFCalParObl_Sel ;
   private byte AV27TFCalParGrp ;
   private byte AV28TFCalParGrp_To ;
   private byte AV29TFCalParGrpDep ;
   private byte AV30TFCalParGrpDep_To ;
   private byte A2104CalParGrp ;
   private byte A2105CalParGrpDep ;
   private short AV55PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV61GXV1 ;
   private int AV13TFCalParNombre_Sels_size ;
   private int AV16TFCalParDesc_Sels_size ;
   private int AV19TFCalParCampo_Sels_size ;
   private int AV22TFCalParValLista_Sels_size ;
   private int AV25TFCalParDef_Sels_size ;
   private int AV33TFCalParEjemplo_Sels_size ;
   private int AV36TFCalParEjemExpli_Sels_size ;
   private long AV43count ;
   private String AV24TFCalParDef ;
   private String AV56idOperando ;
   private String scmdbuf ;
   private String lV24TFCalParDef ;
   private String A2107CalParDef ;
   private String A74idOperando ;
   private String A2098CalParId ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean A2106CalParObl ;
   private boolean brk20L2 ;
   private boolean brk20L4 ;
   private boolean brk20L6 ;
   private boolean brk20L8 ;
   private boolean brk20L10 ;
   private boolean brk20L12 ;
   private boolean brk20L14 ;
   private String AV52OptionsJson ;
   private String AV53OptionsDescJson ;
   private String AV54OptionIndexesJson ;
   private String AV11TFCalParNombre_SelsJson ;
   private String AV14TFCalParDesc_SelsJson ;
   private String AV17TFCalParCampo_SelsJson ;
   private String AV20TFCalParValLista_SelsJson ;
   private String AV23TFCalParDef_SelsJson ;
   private String AV31TFCalParEjemplo_SelsJson ;
   private String AV34TFCalParEjemExpli_SelsJson ;
   private String A2109CalParEjemExpli ;
   private String AV49DDOName ;
   private String AV50SearchTxt ;
   private String AV51SearchTxtTo ;
   private String AV12TFCalParNombre ;
   private String AV15TFCalParDesc ;
   private String AV18TFCalParCampo ;
   private String AV21TFCalParValLista ;
   private String AV32TFCalParEjemplo ;
   private String AV35TFCalParEjemExpli ;
   private String lV12TFCalParNombre ;
   private String lV15TFCalParDesc ;
   private String lV18TFCalParCampo ;
   private String lV21TFCalParValLista ;
   private String lV32TFCalParEjemplo ;
   private String lV35TFCalParEjemExpli ;
   private String A2110CalParNombre ;
   private String A2100CalParDesc ;
   private String A2099CalParCampo ;
   private String A2111CalParValLista ;
   private String A2108CalParEjemplo ;
   private String AV38Option ;
   private com.genexus.webpanels.WebSession AV44Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P020L2_A46PaiCod ;
   private String[] P020L2_A74idOperando ;
   private String[] P020L2_A2110CalParNombre ;
   private String[] P020L2_A2109CalParEjemExpli ;
   private String[] P020L2_A2108CalParEjemplo ;
   private byte[] P020L2_A2105CalParGrpDep ;
   private byte[] P020L2_A2104CalParGrp ;
   private boolean[] P020L2_A2106CalParObl ;
   private String[] P020L2_A2107CalParDef ;
   private String[] P020L2_A2111CalParValLista ;
   private String[] P020L2_A2099CalParCampo ;
   private String[] P020L2_A2100CalParDesc ;
   private String[] P020L2_A2098CalParId ;
   private short[] P020L3_A46PaiCod ;
   private String[] P020L3_A74idOperando ;
   private String[] P020L3_A2100CalParDesc ;
   private String[] P020L3_A2109CalParEjemExpli ;
   private String[] P020L3_A2108CalParEjemplo ;
   private byte[] P020L3_A2105CalParGrpDep ;
   private byte[] P020L3_A2104CalParGrp ;
   private boolean[] P020L3_A2106CalParObl ;
   private String[] P020L3_A2107CalParDef ;
   private String[] P020L3_A2111CalParValLista ;
   private String[] P020L3_A2099CalParCampo ;
   private String[] P020L3_A2110CalParNombre ;
   private String[] P020L3_A2098CalParId ;
   private short[] P020L4_A46PaiCod ;
   private String[] P020L4_A74idOperando ;
   private String[] P020L4_A2099CalParCampo ;
   private String[] P020L4_A2109CalParEjemExpli ;
   private String[] P020L4_A2108CalParEjemplo ;
   private byte[] P020L4_A2105CalParGrpDep ;
   private byte[] P020L4_A2104CalParGrp ;
   private boolean[] P020L4_A2106CalParObl ;
   private String[] P020L4_A2107CalParDef ;
   private String[] P020L4_A2111CalParValLista ;
   private String[] P020L4_A2100CalParDesc ;
   private String[] P020L4_A2110CalParNombre ;
   private String[] P020L4_A2098CalParId ;
   private short[] P020L5_A46PaiCod ;
   private String[] P020L5_A74idOperando ;
   private String[] P020L5_A2111CalParValLista ;
   private String[] P020L5_A2109CalParEjemExpli ;
   private String[] P020L5_A2108CalParEjemplo ;
   private byte[] P020L5_A2105CalParGrpDep ;
   private byte[] P020L5_A2104CalParGrp ;
   private boolean[] P020L5_A2106CalParObl ;
   private String[] P020L5_A2107CalParDef ;
   private String[] P020L5_A2099CalParCampo ;
   private String[] P020L5_A2100CalParDesc ;
   private String[] P020L5_A2110CalParNombre ;
   private String[] P020L5_A2098CalParId ;
   private short[] P020L6_A46PaiCod ;
   private String[] P020L6_A74idOperando ;
   private String[] P020L6_A2107CalParDef ;
   private String[] P020L6_A2109CalParEjemExpli ;
   private String[] P020L6_A2108CalParEjemplo ;
   private byte[] P020L6_A2105CalParGrpDep ;
   private byte[] P020L6_A2104CalParGrp ;
   private boolean[] P020L6_A2106CalParObl ;
   private String[] P020L6_A2111CalParValLista ;
   private String[] P020L6_A2099CalParCampo ;
   private String[] P020L6_A2100CalParDesc ;
   private String[] P020L6_A2110CalParNombre ;
   private String[] P020L6_A2098CalParId ;
   private short[] P020L7_A46PaiCod ;
   private String[] P020L7_A74idOperando ;
   private String[] P020L7_A2108CalParEjemplo ;
   private String[] P020L7_A2109CalParEjemExpli ;
   private byte[] P020L7_A2105CalParGrpDep ;
   private byte[] P020L7_A2104CalParGrp ;
   private boolean[] P020L7_A2106CalParObl ;
   private String[] P020L7_A2107CalParDef ;
   private String[] P020L7_A2111CalParValLista ;
   private String[] P020L7_A2099CalParCampo ;
   private String[] P020L7_A2100CalParDesc ;
   private String[] P020L7_A2110CalParNombre ;
   private String[] P020L7_A2098CalParId ;
   private short[] P020L8_A46PaiCod ;
   private String[] P020L8_A74idOperando ;
   private String[] P020L8_A2109CalParEjemExpli ;
   private String[] P020L8_A2108CalParEjemplo ;
   private byte[] P020L8_A2105CalParGrpDep ;
   private byte[] P020L8_A2104CalParGrp ;
   private boolean[] P020L8_A2106CalParObl ;
   private String[] P020L8_A2107CalParDef ;
   private String[] P020L8_A2111CalParValLista ;
   private String[] P020L8_A2099CalParCampo ;
   private String[] P020L8_A2100CalParDesc ;
   private String[] P020L8_A2110CalParNombre ;
   private String[] P020L8_A2098CalParId ;
   private GXSimpleCollection<String> AV25TFCalParDef_Sels ;
   private GXSimpleCollection<String> AV39Options ;
   private GXSimpleCollection<String> AV41OptionsDesc ;
   private GXSimpleCollection<String> AV42OptionIndexes ;
   private GXSimpleCollection<String> AV13TFCalParNombre_Sels ;
   private GXSimpleCollection<String> AV16TFCalParDesc_Sels ;
   private GXSimpleCollection<String> AV19TFCalParCampo_Sels ;
   private GXSimpleCollection<String> AV22TFCalParValLista_Sels ;
   private GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ;
   private GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV46GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV47GridStateFilterValue ;
}

final  class calculo_parametrostabgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P020L2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[13];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParNombre, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParValLista, CalParCampo, CalParDesc," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int4[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int4[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int4[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParNombre" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P020L3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[13];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParDesc, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParValLista, CalParCampo, CalParNombre," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int7[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int7[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int7[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int7[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParDesc" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P020L4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int10 = new byte[13];
      Object[] GXv_Object11 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParCampo, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParValLista, CalParDesc, CalParNombre," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int10[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int10[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int10[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int10[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int10[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int10[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int10[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int10[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int10[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int10[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int10[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParCampo" ;
      GXv_Object11[0] = scmdbuf ;
      GXv_Object11[1] = GXv_int10 ;
      return GXv_Object11 ;
   }

   protected Object[] conditional_P020L5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[13];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParValLista, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParCampo, CalParDesc, CalParNombre," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int13[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int13[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int13[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int13[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int13[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int13[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int13[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int13[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int13[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int13[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int13[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParValLista" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P020L6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int16 = new byte[13];
      Object[] GXv_Object17 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParDef, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParValLista, CalParCampo, CalParDesc, CalParNombre," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int16[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int16[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int16[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int16[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int16[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int16[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int16[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int16[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int16[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int16[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int16[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParDef" ;
      GXv_Object17[0] = scmdbuf ;
      GXv_Object17[1] = GXv_int16 ;
      return GXv_Object17 ;
   }

   protected Object[] conditional_P020L7( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[13];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParEjemplo, CalParEjemExpli, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParValLista, CalParCampo, CalParDesc, CalParNombre," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int19[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int19[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int19[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int19[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int19[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int19[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int19[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int19[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int19[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParEjemplo" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P020L8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A2110CalParNombre ,
                                          GXSimpleCollection<String> AV13TFCalParNombre_Sels ,
                                          String A2100CalParDesc ,
                                          GXSimpleCollection<String> AV16TFCalParDesc_Sels ,
                                          String A2099CalParCampo ,
                                          GXSimpleCollection<String> AV19TFCalParCampo_Sels ,
                                          String A2111CalParValLista ,
                                          GXSimpleCollection<String> AV22TFCalParValLista_Sels ,
                                          String A2107CalParDef ,
                                          GXSimpleCollection<String> AV25TFCalParDef_Sels ,
                                          String A2108CalParEjemplo ,
                                          GXSimpleCollection<String> AV33TFCalParEjemplo_Sels ,
                                          String A2109CalParEjemExpli ,
                                          GXSimpleCollection<String> AV36TFCalParEjemExpli_Sels ,
                                          int AV13TFCalParNombre_Sels_size ,
                                          String AV12TFCalParNombre ,
                                          int AV16TFCalParDesc_Sels_size ,
                                          String AV15TFCalParDesc ,
                                          int AV19TFCalParCampo_Sels_size ,
                                          String AV18TFCalParCampo ,
                                          int AV22TFCalParValLista_Sels_size ,
                                          String AV21TFCalParValLista ,
                                          int AV25TFCalParDef_Sels_size ,
                                          String AV24TFCalParDef ,
                                          byte AV26TFCalParObl_Sel ,
                                          byte AV27TFCalParGrp ,
                                          byte AV28TFCalParGrp_To ,
                                          byte AV29TFCalParGrpDep ,
                                          byte AV30TFCalParGrpDep_To ,
                                          int AV33TFCalParEjemplo_Sels_size ,
                                          String AV32TFCalParEjemplo ,
                                          int AV36TFCalParEjemExpli_Sels_size ,
                                          String AV35TFCalParEjemExpli ,
                                          boolean A2106CalParObl ,
                                          byte A2104CalParGrp ,
                                          byte A2105CalParGrpDep ,
                                          short AV55PaiCod ,
                                          String AV56idOperando ,
                                          short A46PaiCod ,
                                          String A74idOperando )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[13];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT PaiCod, idOperando, CalParEjemExpli, CalParEjemplo, CalParGrpDep, CalParGrp, CalParObl, CalParDef, CalParValLista, CalParCampo, CalParDesc, CalParNombre," ;
      scmdbuf += " CalParId FROM Calculo_parametros" ;
      addWhere(sWhereString, "(PaiCod = ? and idOperando = ( ?))");
      if ( ( AV13TFCalParNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFCalParNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParNombre) like LOWER(?))");
      }
      else
      {
         GXv_int22[2] = (byte)(1) ;
      }
      if ( AV13TFCalParNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFCalParNombre_Sels, "CalParNombre IN (", ")")+")");
      }
      if ( ( AV16TFCalParDesc_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFCalParDesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDesc) like LOWER(?))");
      }
      else
      {
         GXv_int22[3] = (byte)(1) ;
      }
      if ( AV16TFCalParDesc_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFCalParDesc_Sels, "CalParDesc IN (", ")")+")");
      }
      if ( ( AV19TFCalParCampo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV18TFCalParCampo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParCampo) like LOWER(?))");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( AV19TFCalParCampo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV19TFCalParCampo_Sels, "CalParCampo IN (", ")")+")");
      }
      if ( ( AV22TFCalParValLista_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21TFCalParValLista)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParValLista) like LOWER(?))");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      if ( AV22TFCalParValLista_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22TFCalParValLista_Sels, "CalParValLista IN (", ")")+")");
      }
      if ( ( AV25TFCalParDef_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV24TFCalParDef)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParDef) like LOWER(?))");
      }
      else
      {
         GXv_int22[6] = (byte)(1) ;
      }
      if ( AV25TFCalParDef_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV25TFCalParDef_Sels, "CalParDef IN (", ")")+")");
      }
      if ( AV26TFCalParObl_Sel == 1 )
      {
         addWhere(sWhereString, "(CalParObl = TRUE)");
      }
      if ( AV26TFCalParObl_Sel == 2 )
      {
         addWhere(sWhereString, "(CalParObl = FALSE)");
      }
      if ( ! (0==AV27TFCalParGrp) )
      {
         addWhere(sWhereString, "(CalParGrp >= ?)");
      }
      else
      {
         GXv_int22[7] = (byte)(1) ;
      }
      if ( ! (0==AV28TFCalParGrp_To) )
      {
         addWhere(sWhereString, "(CalParGrp <= ?)");
      }
      else
      {
         GXv_int22[8] = (byte)(1) ;
      }
      if ( ! (0==AV29TFCalParGrpDep) )
      {
         addWhere(sWhereString, "(CalParGrpDep >= ?)");
      }
      else
      {
         GXv_int22[9] = (byte)(1) ;
      }
      if ( ! (0==AV30TFCalParGrpDep_To) )
      {
         addWhere(sWhereString, "(CalParGrpDep <= ?)");
      }
      else
      {
         GXv_int22[10] = (byte)(1) ;
      }
      if ( ( AV33TFCalParEjemplo_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV32TFCalParEjemplo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemplo) like LOWER(?))");
      }
      else
      {
         GXv_int22[11] = (byte)(1) ;
      }
      if ( AV33TFCalParEjemplo_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV33TFCalParEjemplo_Sels, "CalParEjemplo IN (", ")")+")");
      }
      if ( ( AV36TFCalParEjemExpli_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV35TFCalParEjemExpli)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CalParEjemExpli) like LOWER(?))");
      }
      else
      {
         GXv_int22[12] = (byte)(1) ;
      }
      if ( AV36TFCalParEjemExpli_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV36TFCalParEjemExpli_Sels, "CalParEjemExpli IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, idOperando, CalParEjemExpli" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
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
                  return conditional_P020L2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
            case 1 :
                  return conditional_P020L3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
            case 2 :
                  return conditional_P020L4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
            case 3 :
                  return conditional_P020L5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
            case 4 :
                  return conditional_P020L6(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
            case 5 :
                  return conditional_P020L7(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
            case 6 :
                  return conditional_P020L8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , (String)dynConstraints[8] , (GXSimpleCollection<String>)dynConstraints[9] , (String)dynConstraints[10] , (GXSimpleCollection<String>)dynConstraints[11] , (String)dynConstraints[12] , (GXSimpleCollection<String>)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , (String)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , (String)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , (String)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).byteValue() , ((Number) dynConstraints[25]).byteValue() , ((Number) dynConstraints[26]).byteValue() , ((Number) dynConstraints[27]).byteValue() , ((Number) dynConstraints[28]).byteValue() , ((Number) dynConstraints[29]).intValue() , (String)dynConstraints[30] , ((Number) dynConstraints[31]).intValue() , (String)dynConstraints[32] , ((Boolean) dynConstraints[33]).booleanValue() , ((Number) dynConstraints[34]).byteValue() , ((Number) dynConstraints[35]).byteValue() , ((Number) dynConstraints[36]).shortValue() , (String)dynConstraints[37] , ((Number) dynConstraints[38]).shortValue() , (String)dynConstraints[39] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P020L2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020L3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020L4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020L5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020L6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020L7", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P020L8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((String[]) buf[12])[0] = rslt.getString(13, 40);
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
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
            case 5 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[16], 400);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[18], 4000);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[20]).byteValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[21]).byteValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[22]).byteValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[23]).byteValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[24], 400);
               }
               if ( ((Number) parms[12]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[25], 200);
               }
               return;
      }
   }

}

