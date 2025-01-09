package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicional_opcioneswwgetfilterdata extends GXProcedure
{
   public convenio_adicional_opcioneswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_opcioneswwgetfilterdata.class ), "" );
   }

   public convenio_adicional_opcioneswwgetfilterdata( int remoteHandle ,
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
      convenio_adicional_opcioneswwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_adicional_opcioneswwgetfilterdata.this.AV33DDOName = aP0;
      convenio_adicional_opcioneswwgetfilterdata.this.AV34SearchTxt = aP1;
      convenio_adicional_opcioneswwgetfilterdata.this.AV35SearchTxtTo = aP2;
      convenio_adicional_opcioneswwgetfilterdata.this.aP3 = aP3;
      convenio_adicional_opcioneswwgetfilterdata.this.aP4 = aP4;
      convenio_adicional_opcioneswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicional_opcioneswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_adicional_opcioneswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_opciones", GXv_boolean6) ;
      convenio_adicional_opcioneswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_CONVEADICOD") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADICODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_CONVEADIOPCFOR") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADIOPCFOROPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_CONVEADIOPCDES") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADIOPCDESOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV36OptionsJson = AV23Options.toJSonString(false) ;
      AV37OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV38OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("convenio_adicional_opcionesWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_adicional_opcionesWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("convenio_adicional_opcionesWWGridState"), null, null);
      }
      AV54GXV1 = 1 ;
      while ( AV54GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV54GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV43TFConveAdicod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV42TFConveAdicod_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFConveAdicod_Sels.fromJSonString(AV42TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCCOD") == 0 )
         {
            AV11TFConveAdiOpcCod = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFConveAdiOpcCod_To = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCFOR") == 0 )
         {
            AV14TFConveAdiOpcFor = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCFOR_SEL") == 0 )
         {
            AV13TFConveAdiOpcFor_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFConveAdiOpcFor_Sels.fromJSonString(AV13TFConveAdiOpcFor_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCDES") == 0 )
         {
            AV17TFConveAdiOpcDes = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCDES_SEL") == 0 )
         {
            AV16TFConveAdiOpcDes_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFConveAdiOpcDes_Sels.fromJSonString(AV16TFConveAdiOpcDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIOPCALI") == 0 )
         {
            AV19TFConveAdiOpcAli = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV20TFConveAdiOpcAli_To = CommonUtil.decimalVal( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV51MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV54GXV1 = (int)(AV54GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEADICODOPTIONS' Routine */
      returnInSub = false ;
      AV43TFConveAdicod = AV34SearchTxt ;
      AV44TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56Convenio_adicional_opcioneswwds_1_tfconveadicod = AV43TFConveAdicod ;
      AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels = AV44TFConveAdicod_Sels ;
      AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod = AV11TFConveAdiOpcCod ;
      AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to = AV12TFConveAdiOpcCod_To ;
      AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = AV14TFConveAdiOpcFor ;
      AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels = AV15TFConveAdiOpcFor_Sels ;
      AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = AV17TFConveAdiOpcDes ;
      AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels = AV18TFConveAdiOpcDes_Sels ;
      AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali = AV19TFConveAdiOpcAli ;
      AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to = AV20TFConveAdiOpcAli_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                           A1021ConveAdiOpcFor ,
                                           AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                           A1012ConveAdiOpcDes ,
                                           AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                           Integer.valueOf(AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels.size()) ,
                                           AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                           Short.valueOf(AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod) ,
                                           Short.valueOf(AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) ,
                                           Integer.valueOf(AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels.size()) ,
                                           AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                           Integer.valueOf(AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels.size()) ,
                                           AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                           AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                           AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                           Short.valueOf(A1011ConveAdiOpcCod) ,
                                           A1013ConveAdiOpcAli ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           AV46ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.STRING
                                           }
      });
      lV56Convenio_adicional_opcioneswwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV56Convenio_adicional_opcioneswwds_1_tfconveadicod), 20, "%") ;
      lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = GXutil.padr( GXutil.rtrim( AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor), 20, "%") ;
      lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = GXutil.concat( GXutil.rtrim( AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes), "%", "") ;
      /* Using cursor P01GW2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV45PaiCod), AV46ConveCodigo, lV56Convenio_adicional_opcioneswwds_1_tfconveadicod, Short.valueOf(AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod), Short.valueOf(AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to), lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor, lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes, AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali, AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1GW2 = false ;
         A1565CliConvenio = P01GW2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01GW2_A1564CliPaiConve[0] ;
         A3CliCod = P01GW2_A3CliCod[0] ;
         A996ConveAdicod = P01GW2_A996ConveAdicod[0] ;
         A1013ConveAdiOpcAli = P01GW2_A1013ConveAdiOpcAli[0] ;
         A1012ConveAdiOpcDes = P01GW2_A1012ConveAdiOpcDes[0] ;
         A1021ConveAdiOpcFor = P01GW2_A1021ConveAdiOpcFor[0] ;
         A1011ConveAdiOpcCod = P01GW2_A1011ConveAdiOpcCod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01GW2_A3CliCod[0] == A3CliCod ) && ( P01GW2_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01GW2_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( GXutil.strcmp(P01GW2_A996ConveAdicod[0], A996ConveAdicod) == 0 ) )
         {
            brk1GW2 = false ;
            A1011ConveAdiOpcCod = P01GW2_A1011ConveAdiOpcCod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk1GW2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A996ConveAdicod)==0) )
         {
            AV22Option = A996ConveAdicod ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GW2 )
         {
            brk1GW2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONVEADIOPCFOROPTIONS' Routine */
      returnInSub = false ;
      AV14TFConveAdiOpcFor = AV34SearchTxt ;
      AV15TFConveAdiOpcFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56Convenio_adicional_opcioneswwds_1_tfconveadicod = AV43TFConveAdicod ;
      AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels = AV44TFConveAdicod_Sels ;
      AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod = AV11TFConveAdiOpcCod ;
      AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to = AV12TFConveAdiOpcCod_To ;
      AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = AV14TFConveAdiOpcFor ;
      AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels = AV15TFConveAdiOpcFor_Sels ;
      AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = AV17TFConveAdiOpcDes ;
      AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels = AV18TFConveAdiOpcDes_Sels ;
      AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali = AV19TFConveAdiOpcAli ;
      AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to = AV20TFConveAdiOpcAli_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                           A1021ConveAdiOpcFor ,
                                           AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                           A1012ConveAdiOpcDes ,
                                           AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                           Integer.valueOf(AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels.size()) ,
                                           AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                           Short.valueOf(AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod) ,
                                           Short.valueOf(AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) ,
                                           Integer.valueOf(AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels.size()) ,
                                           AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                           Integer.valueOf(AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels.size()) ,
                                           AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                           AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                           AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                           Short.valueOf(A1011ConveAdiOpcCod) ,
                                           A1013ConveAdiOpcAli ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           A1565CliConvenio ,
                                           AV46ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING
                                           }
      });
      lV56Convenio_adicional_opcioneswwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV56Convenio_adicional_opcioneswwds_1_tfconveadicod), 20, "%") ;
      lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = GXutil.padr( GXutil.rtrim( AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor), 20, "%") ;
      lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = GXutil.concat( GXutil.rtrim( AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes), "%", "") ;
      /* Using cursor P01GW3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV45PaiCod), AV46ConveCodigo, lV56Convenio_adicional_opcioneswwds_1_tfconveadicod, Short.valueOf(AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod), Short.valueOf(AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to), lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor, lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes, AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali, AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1GW4 = false ;
         A3CliCod = P01GW3_A3CliCod[0] ;
         A1564CliPaiConve = P01GW3_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01GW3_A1565CliConvenio[0] ;
         A1021ConveAdiOpcFor = P01GW3_A1021ConveAdiOpcFor[0] ;
         A1013ConveAdiOpcAli = P01GW3_A1013ConveAdiOpcAli[0] ;
         A1012ConveAdiOpcDes = P01GW3_A1012ConveAdiOpcDes[0] ;
         A1011ConveAdiOpcCod = P01GW3_A1011ConveAdiOpcCod[0] ;
         A996ConveAdicod = P01GW3_A996ConveAdicod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01GW3_A1021ConveAdiOpcFor[0], A1021ConveAdiOpcFor) == 0 ) )
         {
            brk1GW4 = false ;
            A3CliCod = P01GW3_A3CliCod[0] ;
            A1564CliPaiConve = P01GW3_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01GW3_A1565CliConvenio[0] ;
            A1011ConveAdiOpcCod = P01GW3_A1011ConveAdiOpcCod[0] ;
            A996ConveAdicod = P01GW3_A996ConveAdicod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk1GW4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1021ConveAdiOpcFor)==0) )
         {
            AV22Option = A1021ConveAdiOpcFor ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GW4 )
         {
            brk1GW4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONVEADIOPCDESOPTIONS' Routine */
      returnInSub = false ;
      AV17TFConveAdiOpcDes = AV34SearchTxt ;
      AV18TFConveAdiOpcDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV56Convenio_adicional_opcioneswwds_1_tfconveadicod = AV43TFConveAdicod ;
      AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels = AV44TFConveAdicod_Sels ;
      AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod = AV11TFConveAdiOpcCod ;
      AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to = AV12TFConveAdiOpcCod_To ;
      AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = AV14TFConveAdiOpcFor ;
      AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels = AV15TFConveAdiOpcFor_Sels ;
      AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = AV17TFConveAdiOpcDes ;
      AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels = AV18TFConveAdiOpcDes_Sels ;
      AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali = AV19TFConveAdiOpcAli ;
      AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to = AV20TFConveAdiOpcAli_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                           A1021ConveAdiOpcFor ,
                                           AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                           A1012ConveAdiOpcDes ,
                                           AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                           Integer.valueOf(AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels.size()) ,
                                           AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                           Short.valueOf(AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod) ,
                                           Short.valueOf(AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) ,
                                           Integer.valueOf(AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels.size()) ,
                                           AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                           Integer.valueOf(AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels.size()) ,
                                           AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                           AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                           AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                           Short.valueOf(A1011ConveAdiOpcCod) ,
                                           A1013ConveAdiOpcAli ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV45PaiCod) ,
                                           A1565CliConvenio ,
                                           AV46ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING,
                                           TypeConstants.STRING
                                           }
      });
      lV56Convenio_adicional_opcioneswwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV56Convenio_adicional_opcioneswwds_1_tfconveadicod), 20, "%") ;
      lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = GXutil.padr( GXutil.rtrim( AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor), 20, "%") ;
      lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = GXutil.concat( GXutil.rtrim( AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes), "%", "") ;
      /* Using cursor P01GW4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV45PaiCod), AV46ConveCodigo, lV56Convenio_adicional_opcioneswwds_1_tfconveadicod, Short.valueOf(AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod), Short.valueOf(AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to), lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor, lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes, AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali, AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1GW6 = false ;
         A3CliCod = P01GW4_A3CliCod[0] ;
         A1564CliPaiConve = P01GW4_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01GW4_A1565CliConvenio[0] ;
         A1012ConveAdiOpcDes = P01GW4_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = P01GW4_A1013ConveAdiOpcAli[0] ;
         A1021ConveAdiOpcFor = P01GW4_A1021ConveAdiOpcFor[0] ;
         A1011ConveAdiOpcCod = P01GW4_A1011ConveAdiOpcCod[0] ;
         A996ConveAdicod = P01GW4_A996ConveAdicod[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01GW4_A1012ConveAdiOpcDes[0], A1012ConveAdiOpcDes) == 0 ) )
         {
            brk1GW6 = false ;
            A3CliCod = P01GW4_A3CliCod[0] ;
            A1564CliPaiConve = P01GW4_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01GW4_A1565CliConvenio[0] ;
            A1011ConveAdiOpcCod = P01GW4_A1011ConveAdiOpcCod[0] ;
            A996ConveAdicod = P01GW4_A996ConveAdicod[0] ;
            AV27count = (long)(AV27count+1) ;
            brk1GW6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1012ConveAdiOpcDes)==0) )
         {
            AV22Option = A1012ConveAdiOpcDes ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GW6 )
         {
            brk1GW6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_adicional_opcioneswwgetfilterdata.this.AV36OptionsJson;
      this.aP4[0] = convenio_adicional_opcioneswwgetfilterdata.this.AV37OptionsDescJson;
      this.aP5[0] = convenio_adicional_opcioneswwgetfilterdata.this.AV38OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV36OptionsJson = "" ;
      AV37OptionsDescJson = "" ;
      AV38OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV43TFConveAdicod = "" ;
      AV42TFConveAdicod_SelsJson = "" ;
      AV44TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFConveAdiOpcFor = "" ;
      AV13TFConveAdiOpcFor_SelsJson = "" ;
      AV15TFConveAdiOpcFor_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFConveAdiOpcDes = "" ;
      AV16TFConveAdiOpcDes_SelsJson = "" ;
      AV18TFConveAdiOpcDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFConveAdiOpcAli = DecimalUtil.ZERO ;
      AV20TFConveAdiOpcAli_To = DecimalUtil.ZERO ;
      AV51MenuOpcCod = "" ;
      A996ConveAdicod = "" ;
      AV56Convenio_adicional_opcioneswwds_1_tfconveadicod = "" ;
      AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = "" ;
      AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = "" ;
      AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali = DecimalUtil.ZERO ;
      AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      lV56Convenio_adicional_opcioneswwds_1_tfconveadicod = "" ;
      lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor = "" ;
      lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes = "" ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      AV46ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P01GW2_A1565CliConvenio = new String[] {""} ;
      P01GW2_A1564CliPaiConve = new short[1] ;
      P01GW2_A3CliCod = new int[1] ;
      P01GW2_A996ConveAdicod = new String[] {""} ;
      P01GW2_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GW2_A1012ConveAdiOpcDes = new String[] {""} ;
      P01GW2_A1021ConveAdiOpcFor = new String[] {""} ;
      P01GW2_A1011ConveAdiOpcCod = new short[1] ;
      AV22Option = "" ;
      P01GW3_A3CliCod = new int[1] ;
      P01GW3_A1564CliPaiConve = new short[1] ;
      P01GW3_A1565CliConvenio = new String[] {""} ;
      P01GW3_A1021ConveAdiOpcFor = new String[] {""} ;
      P01GW3_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GW3_A1012ConveAdiOpcDes = new String[] {""} ;
      P01GW3_A1011ConveAdiOpcCod = new short[1] ;
      P01GW3_A996ConveAdicod = new String[] {""} ;
      P01GW4_A3CliCod = new int[1] ;
      P01GW4_A1564CliPaiConve = new short[1] ;
      P01GW4_A1565CliConvenio = new String[] {""} ;
      P01GW4_A1012ConveAdiOpcDes = new String[] {""} ;
      P01GW4_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GW4_A1021ConveAdiOpcFor = new String[] {""} ;
      P01GW4_A1011ConveAdiOpcCod = new short[1] ;
      P01GW4_A996ConveAdicod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional_opcioneswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01GW2_A1565CliConvenio, P01GW2_A1564CliPaiConve, P01GW2_A3CliCod, P01GW2_A996ConveAdicod, P01GW2_A1013ConveAdiOpcAli, P01GW2_A1012ConveAdiOpcDes, P01GW2_A1021ConveAdiOpcFor, P01GW2_A1011ConveAdiOpcCod
            }
            , new Object[] {
            P01GW3_A3CliCod, P01GW3_A1564CliPaiConve, P01GW3_A1565CliConvenio, P01GW3_A1021ConveAdiOpcFor, P01GW3_A1013ConveAdiOpcAli, P01GW3_A1012ConveAdiOpcDes, P01GW3_A1011ConveAdiOpcCod, P01GW3_A996ConveAdicod
            }
            , new Object[] {
            P01GW4_A3CliCod, P01GW4_A1564CliPaiConve, P01GW4_A1565CliConvenio, P01GW4_A1012ConveAdiOpcDes, P01GW4_A1013ConveAdiOpcAli, P01GW4_A1021ConveAdiOpcFor, P01GW4_A1011ConveAdiOpcCod, P01GW4_A996ConveAdicod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFConveAdiOpcCod ;
   private short AV12TFConveAdiOpcCod_To ;
   private short AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod ;
   private short AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to ;
   private short A1011ConveAdiOpcCod ;
   private short AV45PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV54GXV1 ;
   private int AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size ;
   private int AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size ;
   private int AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size ;
   private int A3CliCod ;
   private long AV27count ;
   private java.math.BigDecimal AV19TFConveAdiOpcAli ;
   private java.math.BigDecimal AV20TFConveAdiOpcAli_To ;
   private java.math.BigDecimal AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ;
   private java.math.BigDecimal AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private String AV43TFConveAdicod ;
   private String AV14TFConveAdiOpcFor ;
   private String A996ConveAdicod ;
   private String AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ;
   private String AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ;
   private String scmdbuf ;
   private String lV56Convenio_adicional_opcioneswwds_1_tfconveadicod ;
   private String lV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ;
   private String A1021ConveAdiOpcFor ;
   private String AV46ConveCodigo ;
   private String A1565CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1GW2 ;
   private boolean brk1GW4 ;
   private boolean brk1GW6 ;
   private String AV36OptionsJson ;
   private String AV37OptionsDescJson ;
   private String AV38OptionIndexesJson ;
   private String AV42TFConveAdicod_SelsJson ;
   private String AV13TFConveAdiOpcFor_SelsJson ;
   private String AV16TFConveAdiOpcDes_SelsJson ;
   private String AV33DDOName ;
   private String AV34SearchTxt ;
   private String AV35SearchTxtTo ;
   private String AV17TFConveAdiOpcDes ;
   private String AV51MenuOpcCod ;
   private String AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ;
   private String lV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ;
   private String A1012ConveAdiOpcDes ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GW2_A1565CliConvenio ;
   private short[] P01GW2_A1564CliPaiConve ;
   private int[] P01GW2_A3CliCod ;
   private String[] P01GW2_A996ConveAdicod ;
   private java.math.BigDecimal[] P01GW2_A1013ConveAdiOpcAli ;
   private String[] P01GW2_A1012ConveAdiOpcDes ;
   private String[] P01GW2_A1021ConveAdiOpcFor ;
   private short[] P01GW2_A1011ConveAdiOpcCod ;
   private int[] P01GW3_A3CliCod ;
   private short[] P01GW3_A1564CliPaiConve ;
   private String[] P01GW3_A1565CliConvenio ;
   private String[] P01GW3_A1021ConveAdiOpcFor ;
   private java.math.BigDecimal[] P01GW3_A1013ConveAdiOpcAli ;
   private String[] P01GW3_A1012ConveAdiOpcDes ;
   private short[] P01GW3_A1011ConveAdiOpcCod ;
   private String[] P01GW3_A996ConveAdicod ;
   private int[] P01GW4_A3CliCod ;
   private short[] P01GW4_A1564CliPaiConve ;
   private String[] P01GW4_A1565CliConvenio ;
   private String[] P01GW4_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] P01GW4_A1013ConveAdiOpcAli ;
   private String[] P01GW4_A1021ConveAdiOpcFor ;
   private short[] P01GW4_A1011ConveAdiOpcCod ;
   private String[] P01GW4_A996ConveAdicod ;
   private GXSimpleCollection<String> AV44TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV15TFConveAdiOpcFor_Sels ;
   private GXSimpleCollection<String> AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV18TFConveAdiOpcDes_Sels ;
   private GXSimpleCollection<String> AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class convenio_adicional_opcioneswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01GW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                          String A1021ConveAdiOpcFor ,
                                          GXSimpleCollection<String> AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                          String A1012ConveAdiOpcDes ,
                                          GXSimpleCollection<String> AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                          int AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size ,
                                          String AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                          short AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod ,
                                          short AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to ,
                                          int AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size ,
                                          String AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                          int AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size ,
                                          String AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                          java.math.BigDecimal AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                          java.math.BigDecimal AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                          short A1011ConveAdiOpcCod ,
                                          java.math.BigDecimal A1013ConveAdiOpcAli ,
                                          int AV41CliCod ,
                                          short AV45PaiCod ,
                                          String AV46ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[10];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveAdicod, ConveAdiOpcAli, ConveAdiOpcDes, ConveAdiOpcFor, ConveAdiOpcCod FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Convenio_adicional_opcioneswwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ! (0==AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ( AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcFor) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels, "ConveAdiOpcFor IN (", ")")+")");
      }
      if ( ( AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcDes) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels, "ConveAdiOpcDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli <= ?)");
      }
      else
      {
         GXv_int8[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01GW3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                          String A1021ConveAdiOpcFor ,
                                          GXSimpleCollection<String> AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                          String A1012ConveAdiOpcDes ,
                                          GXSimpleCollection<String> AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                          int AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size ,
                                          String AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                          short AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod ,
                                          short AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to ,
                                          int AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size ,
                                          String AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                          int AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size ,
                                          String AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                          java.math.BigDecimal AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                          java.math.BigDecimal AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                          short A1011ConveAdiOpcCod ,
                                          java.math.BigDecimal A1013ConveAdiOpcAli ,
                                          int A3CliCod ,
                                          int AV41CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV45PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV46ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[10];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdiOpcFor, ConveAdiOpcAli, ConveAdiOpcDes, ConveAdiOpcCod, ConveAdicod FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ( AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Convenio_adicional_opcioneswwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ! (0==AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ( AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcFor) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels, "ConveAdiOpcFor IN (", ")")+")");
      }
      if ( ( AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcDes) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels, "ConveAdiOpcDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveAdiOpcFor" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01GW4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels ,
                                          String A1021ConveAdiOpcFor ,
                                          GXSimpleCollection<String> AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels ,
                                          String A1012ConveAdiOpcDes ,
                                          GXSimpleCollection<String> AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels ,
                                          int AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size ,
                                          String AV56Convenio_adicional_opcioneswwds_1_tfconveadicod ,
                                          short AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod ,
                                          short AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to ,
                                          int AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size ,
                                          String AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor ,
                                          int AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size ,
                                          String AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes ,
                                          java.math.BigDecimal AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali ,
                                          java.math.BigDecimal AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to ,
                                          short A1011ConveAdiOpcCod ,
                                          java.math.BigDecimal A1013ConveAdiOpcAli ,
                                          int A3CliCod ,
                                          int AV41CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV45PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV46ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[10];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcFor, ConveAdiOpcCod, ConveAdicod FROM convenio_adicionalalicuotas" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ( AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Convenio_adicional_opcioneswwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Convenio_adicional_opcioneswwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ! (0==AV58Convenio_adicional_opcioneswwds_3_tfconveadiopccod) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod >= ?)");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( ! (0==AV59Convenio_adicional_opcioneswwds_4_tfconveadiopccod_to) )
      {
         addWhere(sWhereString, "(ConveAdiOpcCod <= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ( AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV60Convenio_adicional_opcioneswwds_5_tfconveadiopcfor)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcFor) like LOWER(?))");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV61Convenio_adicional_opcioneswwds_6_tfconveadiopcfor_sels, "ConveAdiOpcFor IN (", ")")+")");
      }
      if ( ( AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV62Convenio_adicional_opcioneswwds_7_tfconveadiopcdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiOpcDes) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV63Convenio_adicional_opcioneswwds_8_tfconveadiopcdes_sels, "ConveAdiOpcDes IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV64Convenio_adicional_opcioneswwds_9_tfconveadiopcali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli >= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV65Convenio_adicional_opcioneswwds_10_tfconveadiopcali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiOpcAli <= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveAdiOpcDes" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P01GW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).shortValue() , (String)dynConstraints[20] , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] );
            case 1 :
                  return conditional_P01GW3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (String)dynConstraints[22] , (String)dynConstraints[23] );
            case 2 :
                  return conditional_P01GW4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , (java.math.BigDecimal)dynConstraints[14] , (java.math.BigDecimal)dynConstraints[15] , ((Number) dynConstraints[16]).shortValue() , (java.math.BigDecimal)dynConstraints[17] , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).shortValue() , (String)dynConstraints[22] , (String)dynConstraints[23] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01GW3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01GW4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[14]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[15]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 400);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[18], 4);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[19], 4);
               }
               return;
      }
   }

}

