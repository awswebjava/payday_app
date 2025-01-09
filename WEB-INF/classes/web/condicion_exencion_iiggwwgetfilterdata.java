package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicion_exencion_iiggwwgetfilterdata extends GXProcedure
{
   public condicion_exencion_iiggwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicion_exencion_iiggwwgetfilterdata.class ), "" );
   }

   public condicion_exencion_iiggwwgetfilterdata( int remoteHandle ,
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
      condicion_exencion_iiggwwgetfilterdata.this.aP5 = new String[] {""};
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
      condicion_exencion_iiggwwgetfilterdata.this.AV37DDOName = aP0;
      condicion_exencion_iiggwwgetfilterdata.this.AV38SearchTxt = aP1;
      condicion_exencion_iiggwwgetfilterdata.this.AV39SearchTxtTo = aP2;
      condicion_exencion_iiggwwgetfilterdata.this.aP3 = aP3;
      condicion_exencion_iiggwwgetfilterdata.this.aP4 = aP4;
      condicion_exencion_iiggwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV44EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      condicion_exencion_iiggwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV44EmpCod = GXt_int1 ;
      GXt_int3 = AV45CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      condicion_exencion_iiggwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV45CliCod = GXt_int3 ;
      AV27Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWcondicion_exencion_iigg", GXv_boolean6) ;
      condicion_exencion_iiggwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONDEXENIIGG") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDEXENIIGGOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONDEXENIIGGNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDEXENIIGGNOMOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONDEXENRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADCONDEXENRELREFOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV40OptionsJson = AV27Options.toJSonString(false) ;
      AV41OptionsDescJson = AV29OptionsDesc.toJSonString(false) ;
      AV42OptionIndexesJson = AV30OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV32Session.getValue("condicion_exencion_iiggWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "condicion_exencion_iiggWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("condicion_exencion_iiggWWGridState"), null, null);
      }
      AV56GXV1 = 1 ;
      while ( AV56GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV56GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGG") == 0 )
         {
            AV12TFCondExenIIGG = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGG_SEL") == 0 )
         {
            AV11TFCondExenIIGG_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFCondExenIIGG_Sels.fromJSonString(AV11TFCondExenIIGG_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGACU_SEL") == 0 )
         {
            AV17TFCondExenIIGGAcu_Sel = (byte)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGPROM_SEL") == 0 )
         {
            AV18TFCondExenIIGGProm_Sel = (byte)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGVFI") == 0 )
         {
            AV52TFCondExenIIGGVFi = CommonUtil.decimalVal( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV53TFCondExenIIGGVFi_To = CommonUtil.decimalVal( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGOPE_SEL") == 0 )
         {
            AV50TFCondExenIIGGOpe_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV51TFCondExenIIGGOpe_Sels.fromJSonString(AV50TFCondExenIIGGOpe_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGNOM") == 0 )
         {
            AV23TFCondexenIIGGNom = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENIIGGNOM_SEL") == 0 )
         {
            AV22TFCondexenIIGGNom_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFCondexenIIGGNom_Sels.fromJSonString(AV22TFCondexenIIGGNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENRELREF") == 0 )
         {
            AV48TFCondExenRelRef = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONDEXENRELREF_SEL") == 0 )
         {
            AV47TFCondExenRelRef_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV49TFCondExenRelRef_Sels.fromJSonString(AV47TFCondExenRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV46MenuOpcCod = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV56GXV1 = (int)(AV56GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONDEXENIIGGOPTIONS' Routine */
      returnInSub = false ;
      AV12TFCondExenIIGG = AV38SearchTxt ;
      AV13TFCondExenIIGG_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = AV12TFCondExenIIGG ;
      AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels = AV13TFCondExenIIGG_Sels ;
      AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel = AV17TFCondExenIIGGAcu_Sel ;
      AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel = AV18TFCondExenIIGGProm_Sel ;
      AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi = AV52TFCondExenIIGGVFi ;
      AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to = AV53TFCondExenIIGGVFi_To ;
      AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels = AV51TFCondExenIIGGOpe_Sels ;
      AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = AV23TFCondexenIIGGNom ;
      AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels = AV24TFCondexenIIGGNom_Sels ;
      AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = AV48TFCondExenRelRef ;
      AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels = AV49TFCondExenRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1105CondExenIIGG ,
                                           AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                           A2238CondExenIIGGOpe ,
                                           AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                           A1108CondexenIIGGNom ,
                                           AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                           A2021CondExenRelRef ,
                                           AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                           Integer.valueOf(AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels.size()) ,
                                           AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                           Byte.valueOf(AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel) ,
                                           Byte.valueOf(AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel) ,
                                           AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                           AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                           Integer.valueOf(AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels.size()) ,
                                           Integer.valueOf(AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels.size()) ,
                                           AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                           Integer.valueOf(AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels.size()) ,
                                           AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                           Boolean.valueOf(A1106CondExenIIGGAcu) ,
                                           Boolean.valueOf(A1107CondExenIIGGProm) ,
                                           A2237CondExenIIGGVFi ,
                                           Integer.valueOf(AV45CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = GXutil.padr( GXutil.rtrim( AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg), 20, "%") ;
      lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = GXutil.concat( GXutil.rtrim( AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom), "%", "") ;
      lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = GXutil.concat( GXutil.rtrim( AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref), "%", "") ;
      /* Using cursor P017V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV45CliCod), lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg, AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi, AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to, lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom, lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk17V2 = false ;
         A3CliCod = P017V2_A3CliCod[0] ;
         A1105CondExenIIGG = P017V2_A1105CondExenIIGG[0] ;
         A2021CondExenRelRef = P017V2_A2021CondExenRelRef[0] ;
         A1108CondexenIIGGNom = P017V2_A1108CondexenIIGGNom[0] ;
         A2238CondExenIIGGOpe = P017V2_A2238CondExenIIGGOpe[0] ;
         A2237CondExenIIGGVFi = P017V2_A2237CondExenIIGGVFi[0] ;
         A1107CondExenIIGGProm = P017V2_A1107CondExenIIGGProm[0] ;
         A1106CondExenIIGGAcu = P017V2_A1106CondExenIIGGAcu[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P017V2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P017V2_A1105CondExenIIGG[0], A1105CondExenIIGG) == 0 ) )
         {
            brk17V2 = false ;
            AV31count = (long)(AV31count+1) ;
            brk17V2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1105CondExenIIGG)==0) )
         {
            AV26Option = A1105CondExenIIGG ;
            AV27Options.add(AV26Option, 0);
            AV30OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV27Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17V2 )
         {
            brk17V2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONDEXENIIGGNOMOPTIONS' Routine */
      returnInSub = false ;
      AV23TFCondexenIIGGNom = AV38SearchTxt ;
      AV24TFCondexenIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = AV12TFCondExenIIGG ;
      AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels = AV13TFCondExenIIGG_Sels ;
      AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel = AV17TFCondExenIIGGAcu_Sel ;
      AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel = AV18TFCondExenIIGGProm_Sel ;
      AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi = AV52TFCondExenIIGGVFi ;
      AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to = AV53TFCondExenIIGGVFi_To ;
      AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels = AV51TFCondExenIIGGOpe_Sels ;
      AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = AV23TFCondexenIIGGNom ;
      AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels = AV24TFCondexenIIGGNom_Sels ;
      AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = AV48TFCondExenRelRef ;
      AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels = AV49TFCondExenRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1105CondExenIIGG ,
                                           AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                           A2238CondExenIIGGOpe ,
                                           AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                           A1108CondexenIIGGNom ,
                                           AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                           A2021CondExenRelRef ,
                                           AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                           Integer.valueOf(AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels.size()) ,
                                           AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                           Byte.valueOf(AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel) ,
                                           Byte.valueOf(AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel) ,
                                           AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                           AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                           Integer.valueOf(AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels.size()) ,
                                           Integer.valueOf(AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels.size()) ,
                                           AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                           Integer.valueOf(AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels.size()) ,
                                           AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                           Boolean.valueOf(A1106CondExenIIGGAcu) ,
                                           Boolean.valueOf(A1107CondExenIIGGProm) ,
                                           A2237CondExenIIGGVFi ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV45CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = GXutil.padr( GXutil.rtrim( AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg), 20, "%") ;
      lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = GXutil.concat( GXutil.rtrim( AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom), "%", "") ;
      lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = GXutil.concat( GXutil.rtrim( AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref), "%", "") ;
      /* Using cursor P017V3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV45CliCod), lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg, AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi, AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to, lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom, lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk17V4 = false ;
         A3CliCod = P017V3_A3CliCod[0] ;
         A1108CondexenIIGGNom = P017V3_A1108CondexenIIGGNom[0] ;
         A2021CondExenRelRef = P017V3_A2021CondExenRelRef[0] ;
         A2238CondExenIIGGOpe = P017V3_A2238CondExenIIGGOpe[0] ;
         A2237CondExenIIGGVFi = P017V3_A2237CondExenIIGGVFi[0] ;
         A1107CondExenIIGGProm = P017V3_A1107CondExenIIGGProm[0] ;
         A1106CondExenIIGGAcu = P017V3_A1106CondExenIIGGAcu[0] ;
         A1105CondExenIIGG = P017V3_A1105CondExenIIGG[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P017V3_A1108CondexenIIGGNom[0], A1108CondexenIIGGNom) == 0 ) )
         {
            brk17V4 = false ;
            A3CliCod = P017V3_A3CliCod[0] ;
            A1105CondExenIIGG = P017V3_A1105CondExenIIGG[0] ;
            AV31count = (long)(AV31count+1) ;
            brk17V4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1108CondexenIIGGNom)==0) )
         {
            AV26Option = A1108CondexenIIGGNom ;
            AV27Options.add(AV26Option, 0);
            AV30OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV27Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17V4 )
         {
            brk17V4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONDEXENRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV48TFCondExenRelRef = AV38SearchTxt ;
      AV49TFCondExenRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = AV12TFCondExenIIGG ;
      AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels = AV13TFCondExenIIGG_Sels ;
      AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel = AV17TFCondExenIIGGAcu_Sel ;
      AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel = AV18TFCondExenIIGGProm_Sel ;
      AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi = AV52TFCondExenIIGGVFi ;
      AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to = AV53TFCondExenIIGGVFi_To ;
      AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels = AV51TFCondExenIIGGOpe_Sels ;
      AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = AV23TFCondexenIIGGNom ;
      AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels = AV24TFCondexenIIGGNom_Sels ;
      AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = AV48TFCondExenRelRef ;
      AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels = AV49TFCondExenRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A1105CondExenIIGG ,
                                           AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                           A2238CondExenIIGGOpe ,
                                           AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                           A1108CondexenIIGGNom ,
                                           AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                           A2021CondExenRelRef ,
                                           AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                           Integer.valueOf(AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels.size()) ,
                                           AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                           Byte.valueOf(AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel) ,
                                           Byte.valueOf(AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel) ,
                                           AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                           AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                           Integer.valueOf(AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels.size()) ,
                                           Integer.valueOf(AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels.size()) ,
                                           AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                           Integer.valueOf(AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels.size()) ,
                                           AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                           Boolean.valueOf(A1106CondExenIIGGAcu) ,
                                           Boolean.valueOf(A1107CondExenIIGGProm) ,
                                           A2237CondExenIIGGVFi ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV45CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = GXutil.padr( GXutil.rtrim( AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg), 20, "%") ;
      lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = GXutil.concat( GXutil.rtrim( AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom), "%", "") ;
      lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = GXutil.concat( GXutil.rtrim( AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref), "%", "") ;
      /* Using cursor P017V4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV45CliCod), lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg, AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi, AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to, lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom, lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk17V6 = false ;
         A3CliCod = P017V4_A3CliCod[0] ;
         A2021CondExenRelRef = P017V4_A2021CondExenRelRef[0] ;
         A1108CondexenIIGGNom = P017V4_A1108CondexenIIGGNom[0] ;
         A2238CondExenIIGGOpe = P017V4_A2238CondExenIIGGOpe[0] ;
         A2237CondExenIIGGVFi = P017V4_A2237CondExenIIGGVFi[0] ;
         A1107CondExenIIGGProm = P017V4_A1107CondExenIIGGProm[0] ;
         A1106CondExenIIGGAcu = P017V4_A1106CondExenIIGGAcu[0] ;
         A1105CondExenIIGG = P017V4_A1105CondExenIIGG[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P017V4_A2021CondExenRelRef[0], A2021CondExenRelRef) == 0 ) )
         {
            brk17V6 = false ;
            A3CliCod = P017V4_A3CliCod[0] ;
            A1105CondExenIIGG = P017V4_A1105CondExenIIGG[0] ;
            AV31count = (long)(AV31count+1) ;
            brk17V6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2021CondExenRelRef)==0) )
         {
            AV26Option = A2021CondExenRelRef ;
            AV27Options.add(AV26Option, 0);
            AV30OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV27Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk17V6 )
         {
            brk17V6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = condicion_exencion_iiggwwgetfilterdata.this.AV40OptionsJson;
      this.aP4[0] = condicion_exencion_iiggwwgetfilterdata.this.AV41OptionsDescJson;
      this.aP5[0] = condicion_exencion_iiggwwgetfilterdata.this.AV42OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV40OptionsJson = "" ;
      AV41OptionsDescJson = "" ;
      AV42OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV27Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV32Session = httpContext.getWebSession();
      AV34GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV35GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFCondExenIIGG = "" ;
      AV11TFCondExenIIGG_SelsJson = "" ;
      AV13TFCondExenIIGG_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52TFCondExenIIGGVFi = DecimalUtil.ZERO ;
      AV53TFCondExenIIGGVFi_To = DecimalUtil.ZERO ;
      AV50TFCondExenIIGGOpe_SelsJson = "" ;
      AV51TFCondExenIIGGOpe_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFCondexenIIGGNom = "" ;
      AV22TFCondexenIIGGNom_SelsJson = "" ;
      AV24TFCondexenIIGGNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48TFCondExenRelRef = "" ;
      AV47TFCondExenRelRef_SelsJson = "" ;
      AV49TFCondExenRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46MenuOpcCod = "" ;
      A1105CondExenIIGG = "" ;
      AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = "" ;
      AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi = DecimalUtil.ZERO ;
      AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to = DecimalUtil.ZERO ;
      AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = "" ;
      AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = "" ;
      AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg = "" ;
      lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom = "" ;
      lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref = "" ;
      A2238CondExenIIGGOpe = "" ;
      A1108CondexenIIGGNom = "" ;
      A2021CondExenRelRef = "" ;
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      P017V2_A3CliCod = new int[1] ;
      P017V2_A1105CondExenIIGG = new String[] {""} ;
      P017V2_A2021CondExenRelRef = new String[] {""} ;
      P017V2_A1108CondexenIIGGNom = new String[] {""} ;
      P017V2_A2238CondExenIIGGOpe = new String[] {""} ;
      P017V2_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017V2_A1107CondExenIIGGProm = new boolean[] {false} ;
      P017V2_A1106CondExenIIGGAcu = new boolean[] {false} ;
      AV26Option = "" ;
      P017V3_A3CliCod = new int[1] ;
      P017V3_A1108CondexenIIGGNom = new String[] {""} ;
      P017V3_A2021CondExenRelRef = new String[] {""} ;
      P017V3_A2238CondExenIIGGOpe = new String[] {""} ;
      P017V3_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017V3_A1107CondExenIIGGProm = new boolean[] {false} ;
      P017V3_A1106CondExenIIGGAcu = new boolean[] {false} ;
      P017V3_A1105CondExenIIGG = new String[] {""} ;
      P017V4_A3CliCod = new int[1] ;
      P017V4_A2021CondExenRelRef = new String[] {""} ;
      P017V4_A1108CondexenIIGGNom = new String[] {""} ;
      P017V4_A2238CondExenIIGGOpe = new String[] {""} ;
      P017V4_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P017V4_A1107CondExenIIGGProm = new boolean[] {false} ;
      P017V4_A1106CondExenIIGGAcu = new boolean[] {false} ;
      P017V4_A1105CondExenIIGG = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicion_exencion_iiggwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P017V2_A3CliCod, P017V2_A1105CondExenIIGG, P017V2_A2021CondExenRelRef, P017V2_A1108CondexenIIGGNom, P017V2_A2238CondExenIIGGOpe, P017V2_A2237CondExenIIGGVFi, P017V2_A1107CondExenIIGGProm, P017V2_A1106CondExenIIGGAcu
            }
            , new Object[] {
            P017V3_A3CliCod, P017V3_A1108CondexenIIGGNom, P017V3_A2021CondExenRelRef, P017V3_A2238CondExenIIGGOpe, P017V3_A2237CondExenIIGGVFi, P017V3_A1107CondExenIIGGProm, P017V3_A1106CondExenIIGGAcu, P017V3_A1105CondExenIIGG
            }
            , new Object[] {
            P017V4_A3CliCod, P017V4_A2021CondExenRelRef, P017V4_A1108CondexenIIGGNom, P017V4_A2238CondExenIIGGOpe, P017V4_A2237CondExenIIGGVFi, P017V4_A1107CondExenIIGGProm, P017V4_A1106CondExenIIGGAcu, P017V4_A1105CondExenIIGG
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV17TFCondExenIIGGAcu_Sel ;
   private byte AV18TFCondExenIIGGProm_Sel ;
   private byte AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel ;
   private byte AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel ;
   private short AV44EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV45CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV56GXV1 ;
   private int AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size ;
   private int AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size ;
   private int AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size ;
   private int AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size ;
   private int A3CliCod ;
   private long AV31count ;
   private java.math.BigDecimal AV52TFCondExenIIGGVFi ;
   private java.math.BigDecimal AV53TFCondExenIIGGVFi_To ;
   private java.math.BigDecimal AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ;
   private java.math.BigDecimal AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private String AV12TFCondExenIIGG ;
   private String A1105CondExenIIGG ;
   private String AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ;
   private String scmdbuf ;
   private String lV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ;
   private String A2238CondExenIIGGOpe ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1106CondExenIIGGAcu ;
   private boolean A1107CondExenIIGGProm ;
   private boolean brk17V2 ;
   private boolean brk17V4 ;
   private boolean brk17V6 ;
   private String AV40OptionsJson ;
   private String AV41OptionsDescJson ;
   private String AV42OptionIndexesJson ;
   private String AV11TFCondExenIIGG_SelsJson ;
   private String AV50TFCondExenIIGGOpe_SelsJson ;
   private String AV22TFCondexenIIGGNom_SelsJson ;
   private String AV47TFCondExenRelRef_SelsJson ;
   private String AV37DDOName ;
   private String AV38SearchTxt ;
   private String AV39SearchTxtTo ;
   private String AV23TFCondexenIIGGNom ;
   private String AV48TFCondExenRelRef ;
   private String AV46MenuOpcCod ;
   private String AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ;
   private String AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ;
   private String lV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ;
   private String lV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ;
   private String A1108CondexenIIGGNom ;
   private String A2021CondExenRelRef ;
   private String AV26Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P017V2_A3CliCod ;
   private String[] P017V2_A1105CondExenIIGG ;
   private String[] P017V2_A2021CondExenRelRef ;
   private String[] P017V2_A1108CondexenIIGGNom ;
   private String[] P017V2_A2238CondExenIIGGOpe ;
   private java.math.BigDecimal[] P017V2_A2237CondExenIIGGVFi ;
   private boolean[] P017V2_A1107CondExenIIGGProm ;
   private boolean[] P017V2_A1106CondExenIIGGAcu ;
   private int[] P017V3_A3CliCod ;
   private String[] P017V3_A1108CondexenIIGGNom ;
   private String[] P017V3_A2021CondExenRelRef ;
   private String[] P017V3_A2238CondExenIIGGOpe ;
   private java.math.BigDecimal[] P017V3_A2237CondExenIIGGVFi ;
   private boolean[] P017V3_A1107CondExenIIGGProm ;
   private boolean[] P017V3_A1106CondExenIIGGAcu ;
   private String[] P017V3_A1105CondExenIIGG ;
   private int[] P017V4_A3CliCod ;
   private String[] P017V4_A2021CondExenRelRef ;
   private String[] P017V4_A1108CondexenIIGGNom ;
   private String[] P017V4_A2238CondExenIIGGOpe ;
   private java.math.BigDecimal[] P017V4_A2237CondExenIIGGVFi ;
   private boolean[] P017V4_A1107CondExenIIGGProm ;
   private boolean[] P017V4_A1106CondExenIIGGAcu ;
   private String[] P017V4_A1105CondExenIIGG ;
   private GXSimpleCollection<String> AV13TFCondExenIIGG_Sels ;
   private GXSimpleCollection<String> AV51TFCondExenIIGGOpe_Sels ;
   private GXSimpleCollection<String> AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ;
   private GXSimpleCollection<String> AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ;
   private GXSimpleCollection<String> AV27Options ;
   private GXSimpleCollection<String> AV29OptionsDesc ;
   private GXSimpleCollection<String> AV30OptionIndexes ;
   private GXSimpleCollection<String> AV24TFCondexenIIGGNom_Sels ;
   private GXSimpleCollection<String> AV49TFCondExenRelRef_Sels ;
   private GXSimpleCollection<String> AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ;
   private GXSimpleCollection<String> AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class condicion_exencion_iiggwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P017V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1105CondExenIIGG ,
                                          GXSimpleCollection<String> AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                          String A2238CondExenIIGGOpe ,
                                          GXSimpleCollection<String> AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                          String A1108CondexenIIGGNom ,
                                          GXSimpleCollection<String> AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                          String A2021CondExenRelRef ,
                                          GXSimpleCollection<String> AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                          int AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size ,
                                          String AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                          byte AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel ,
                                          byte AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel ,
                                          java.math.BigDecimal AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                          java.math.BigDecimal AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                          int AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size ,
                                          int AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size ,
                                          String AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                          int AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size ,
                                          String AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                          boolean A1106CondExenIIGGAcu ,
                                          boolean A1107CondExenIIGGProm ,
                                          java.math.BigDecimal A2237CondExenIIGGVFi ,
                                          int AV45CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, CondExenIIGG, CondExenRelRef, CondexenIIGGNom, CondExenIIGGOpe, CondExenIIGGVFi, CondExenIIGGProm, CondExenIIGGAcu FROM condicion_exencion_iigg" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenIIGG) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels, "CondExenIIGG IN (", ")")+")");
      }
      if ( AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = TRUE)");
      }
      if ( AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = FALSE)");
      }
      if ( AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = TRUE)");
      }
      if ( AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels, "CondExenIIGGOpe IN (", ")")+")");
      }
      if ( ( AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondexenIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels, "CondexenIIGGNom IN (", ")")+")");
      }
      if ( ( AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels, "CondExenRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CondExenIIGG" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P017V3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1105CondExenIIGG ,
                                          GXSimpleCollection<String> AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                          String A2238CondExenIIGGOpe ,
                                          GXSimpleCollection<String> AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                          String A1108CondexenIIGGNom ,
                                          GXSimpleCollection<String> AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                          String A2021CondExenRelRef ,
                                          GXSimpleCollection<String> AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                          int AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size ,
                                          String AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                          byte AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel ,
                                          byte AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel ,
                                          java.math.BigDecimal AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                          java.math.BigDecimal AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                          int AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size ,
                                          int AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size ,
                                          String AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                          int AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size ,
                                          String AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                          boolean A1106CondExenIIGGAcu ,
                                          boolean A1107CondExenIIGGProm ,
                                          java.math.BigDecimal A2237CondExenIIGGVFi ,
                                          int A3CliCod ,
                                          int AV45CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CondexenIIGGNom, CondExenRelRef, CondExenIIGGOpe, CondExenIIGGVFi, CondExenIIGGProm, CondExenIIGGAcu, CondExenIIGG FROM condicion_exencion_iigg" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenIIGG) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels, "CondExenIIGG IN (", ")")+")");
      }
      if ( AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = TRUE)");
      }
      if ( AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = FALSE)");
      }
      if ( AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = TRUE)");
      }
      if ( AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels, "CondExenIIGGOpe IN (", ")")+")");
      }
      if ( ( AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondexenIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels, "CondexenIIGGNom IN (", ")")+")");
      }
      if ( ( AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels, "CondExenRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CondexenIIGGNom" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P017V4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1105CondExenIIGG ,
                                          GXSimpleCollection<String> AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels ,
                                          String A2238CondExenIIGGOpe ,
                                          GXSimpleCollection<String> AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels ,
                                          String A1108CondexenIIGGNom ,
                                          GXSimpleCollection<String> AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels ,
                                          String A2021CondExenRelRef ,
                                          GXSimpleCollection<String> AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels ,
                                          int AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size ,
                                          String AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg ,
                                          byte AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel ,
                                          byte AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel ,
                                          java.math.BigDecimal AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi ,
                                          java.math.BigDecimal AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to ,
                                          int AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size ,
                                          int AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size ,
                                          String AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom ,
                                          int AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size ,
                                          String AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref ,
                                          boolean A1106CondExenIIGGAcu ,
                                          boolean A1107CondExenIIGGProm ,
                                          java.math.BigDecimal A2237CondExenIIGGVFi ,
                                          int A3CliCod ,
                                          int AV45CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, CondExenRelRef, CondexenIIGGNom, CondExenIIGGOpe, CondExenIIGGVFi, CondExenIIGGProm, CondExenIIGGAcu, CondExenIIGG FROM condicion_exencion_iigg" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Condicion_exencion_iiggwwds_1_tfcondexeniigg)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenIIGG) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Condicion_exencion_iiggwwds_2_tfcondexeniigg_sels, "CondExenIIGG IN (", ")")+")");
      }
      if ( AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = TRUE)");
      }
      if ( AV60Condicion_exencion_iiggwwds_3_tfcondexeniiggacu_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGAcu = FALSE)");
      }
      if ( AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 1 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = TRUE)");
      }
      if ( AV61Condicion_exencion_iiggwwds_4_tfcondexeniiggprom_sel == 2 )
      {
         addWhere(sWhereString, "(CondExenIIGGProm = FALSE)");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV62Condicion_exencion_iiggwwds_5_tfcondexeniiggvfi)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi >= ?)");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV63Condicion_exencion_iiggwwds_6_tfcondexeniiggvfi_to)==0) )
      {
         addWhere(sWhereString, "(CondExenIIGGVFi <= ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV64Condicion_exencion_iiggwwds_7_tfcondexeniiggope_sels, "CondExenIIGGOpe IN (", ")")+")");
      }
      if ( ( AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV65Condicion_exencion_iiggwwds_8_tfcondexeniiggnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondexenIIGGNom) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV66Condicion_exencion_iiggwwds_9_tfcondexeniiggnom_sels, "CondexenIIGGNom IN (", ")")+")");
      }
      if ( ( AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Condicion_exencion_iiggwwds_10_tfcondexenrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CondExenRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Condicion_exencion_iiggwwds_11_tfcondexenrelref_sels, "CondExenRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CondExenRelRef" ;
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
                  return conditional_P017V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Boolean) dynConstraints[19]).booleanValue() , ((Boolean) dynConstraints[20]).booleanValue() , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() );
            case 1 :
                  return conditional_P017V3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Boolean) dynConstraints[19]).booleanValue() , ((Boolean) dynConstraints[20]).booleanValue() , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() );
            case 2 :
                  return conditional_P017V4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).byteValue() , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Boolean) dynConstraints[19]).booleanValue() , ((Boolean) dynConstraints[20]).booleanValue() , (java.math.BigDecimal)dynConstraints[21] , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P017V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017V3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P017V4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[8], 2);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               return;
      }
   }

}

