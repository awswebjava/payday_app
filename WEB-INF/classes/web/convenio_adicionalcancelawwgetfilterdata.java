package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicionalcancelawwgetfilterdata extends GXProcedure
{
   public convenio_adicionalcancelawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalcancelawwgetfilterdata.class ), "" );
   }

   public convenio_adicionalcancelawwgetfilterdata( int remoteHandle ,
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
      convenio_adicionalcancelawwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_adicionalcancelawwgetfilterdata.this.AV29DDOName = aP0;
      convenio_adicionalcancelawwgetfilterdata.this.AV30SearchTxt = aP1;
      convenio_adicionalcancelawwgetfilterdata.this.AV31SearchTxtTo = aP2;
      convenio_adicionalcancelawwgetfilterdata.this.aP3 = aP3;
      convenio_adicionalcancelawwgetfilterdata.this.aP4 = aP4;
      convenio_adicionalcancelawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      convenio_adicionalcancelawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_adicionalcancelawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicionalCancela", GXv_boolean6) ;
      convenio_adicionalcancelawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CONVEADICOD") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CONVEADISITCANCELA") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADISITCANCELAOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CONVEADISITCANCDES") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADISITCANCDESOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV32OptionsJson = AV19Options.toJSonString(false) ;
      AV33OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV22OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("convenio_adicionalCancelaWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_adicionalCancelaWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("convenio_adicionalCancelaWWGridState"), null, null);
      }
      AV49GXV1 = 1 ;
      while ( AV49GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV49GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV41TFConveAdicod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV40TFConveAdicod_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFConveAdicod_Sels.fromJSonString(AV40TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCELA") == 0 )
         {
            AV12TFConveAdiSitCancela = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCELA_SEL") == 0 )
         {
            AV11TFConveAdiSitCancela_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFConveAdiSitCancela_Sels.fromJSonString(AV11TFConveAdiSitCancela_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCDES") == 0 )
         {
            AV15TFConveAdiSitCancDes = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADISITCANCDES_SEL") == 0 )
         {
            AV14TFConveAdiSitCancDes_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFConveAdiSitCancDes_Sels.fromJSonString(AV14TFConveAdiSitCancDes_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV46MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV49GXV1 = (int)(AV49GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEADICODOPTIONS' Routine */
      returnInSub = false ;
      AV41TFConveAdicod = AV30SearchTxt ;
      AV42TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Convenio_adicionalcancelawwds_1_tfconveadicod = AV41TFConveAdicod ;
      AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels = AV42TFConveAdicod_Sels ;
      AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = AV12TFConveAdiSitCancela ;
      AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels = AV13TFConveAdiSitCancela_Sels ;
      AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = AV15TFConveAdiSitCancDes ;
      AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels = AV16TFConveAdiSitCancDes_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                           A1824ConveAdiSitCancela ,
                                           AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                           A1825ConveAdiSitCancDes ,
                                           AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                           Integer.valueOf(AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels.size()) ,
                                           AV51Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                           Integer.valueOf(AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels.size()) ,
                                           AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                           Integer.valueOf(AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels.size()) ,
                                           AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                           Integer.valueOf(AV37CliCod) ,
                                           Short.valueOf(AV38PaiCod) ,
                                           AV39ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV51Convenio_adicionalcancelawwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV51Convenio_adicionalcancelawwds_1_tfconveadicod), 20, "%") ;
      lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = GXutil.padr( GXutil.rtrim( AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela), 4, "%") ;
      lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = GXutil.concat( GXutil.rtrim( AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes), "%", "") ;
      /* Using cursor P01PY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV37CliCod), Short.valueOf(AV38PaiCod), AV39ConveCodigo, lV51Convenio_adicionalcancelawwds_1_tfconveadicod, lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela, lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1PY2 = false ;
         A1565CliConvenio = P01PY2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01PY2_A1564CliPaiConve[0] ;
         A3CliCod = P01PY2_A3CliCod[0] ;
         A996ConveAdicod = P01PY2_A996ConveAdicod[0] ;
         A1825ConveAdiSitCancDes = P01PY2_A1825ConveAdiSitCancDes[0] ;
         A1824ConveAdiSitCancela = P01PY2_A1824ConveAdiSitCancela[0] ;
         A1825ConveAdiSitCancDes = P01PY2_A1825ConveAdiSitCancDes[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01PY2_A3CliCod[0] == A3CliCod ) && ( P01PY2_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01PY2_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( GXutil.strcmp(P01PY2_A996ConveAdicod[0], A996ConveAdicod) == 0 ) )
         {
            brk1PY2 = false ;
            A1824ConveAdiSitCancela = P01PY2_A1824ConveAdiSitCancela[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1PY2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A996ConveAdicod)==0) )
         {
            AV18Option = A996ConveAdicod ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PY2 )
         {
            brk1PY2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONVEADISITCANCELAOPTIONS' Routine */
      returnInSub = false ;
      AV12TFConveAdiSitCancela = AV30SearchTxt ;
      AV13TFConveAdiSitCancela_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Convenio_adicionalcancelawwds_1_tfconveadicod = AV41TFConveAdicod ;
      AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels = AV42TFConveAdicod_Sels ;
      AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = AV12TFConveAdiSitCancela ;
      AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels = AV13TFConveAdiSitCancela_Sels ;
      AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = AV15TFConveAdiSitCancDes ;
      AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels = AV16TFConveAdiSitCancDes_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                           A1824ConveAdiSitCancela ,
                                           AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                           A1825ConveAdiSitCancDes ,
                                           AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                           Integer.valueOf(AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels.size()) ,
                                           AV51Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                           Integer.valueOf(AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels.size()) ,
                                           AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                           Integer.valueOf(AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels.size()) ,
                                           AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV38PaiCod) ,
                                           A1565CliConvenio ,
                                           AV39ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV51Convenio_adicionalcancelawwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV51Convenio_adicionalcancelawwds_1_tfconveadicod), 20, "%") ;
      lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = GXutil.padr( GXutil.rtrim( AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela), 4, "%") ;
      lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = GXutil.concat( GXutil.rtrim( AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes), "%", "") ;
      /* Using cursor P01PY3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV37CliCod), Short.valueOf(AV38PaiCod), AV39ConveCodigo, lV51Convenio_adicionalcancelawwds_1_tfconveadicod, lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela, lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1PY4 = false ;
         A1824ConveAdiSitCancela = P01PY3_A1824ConveAdiSitCancela[0] ;
         A1565CliConvenio = P01PY3_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01PY3_A1564CliPaiConve[0] ;
         A3CliCod = P01PY3_A3CliCod[0] ;
         A1825ConveAdiSitCancDes = P01PY3_A1825ConveAdiSitCancDes[0] ;
         A996ConveAdicod = P01PY3_A996ConveAdicod[0] ;
         A1825ConveAdiSitCancDes = P01PY3_A1825ConveAdiSitCancDes[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01PY3_A1824ConveAdiSitCancela[0], A1824ConveAdiSitCancela) == 0 ) )
         {
            brk1PY4 = false ;
            A1565CliConvenio = P01PY3_A1565CliConvenio[0] ;
            A1564CliPaiConve = P01PY3_A1564CliPaiConve[0] ;
            A3CliCod = P01PY3_A3CliCod[0] ;
            A996ConveAdicod = P01PY3_A996ConveAdicod[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1PY4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1824ConveAdiSitCancela)==0) )
         {
            AV18Option = A1824ConveAdiSitCancela ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PY4 )
         {
            brk1PY4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONVEADISITCANCDESOPTIONS' Routine */
      returnInSub = false ;
      AV15TFConveAdiSitCancDes = AV30SearchTxt ;
      AV16TFConveAdiSitCancDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV51Convenio_adicionalcancelawwds_1_tfconveadicod = AV41TFConveAdicod ;
      AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels = AV42TFConveAdicod_Sels ;
      AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = AV12TFConveAdiSitCancela ;
      AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels = AV13TFConveAdiSitCancela_Sels ;
      AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = AV15TFConveAdiSitCancDes ;
      AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels = AV16TFConveAdiSitCancDes_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                           A1824ConveAdiSitCancela ,
                                           AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                           A1825ConveAdiSitCancDes ,
                                           AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                           Integer.valueOf(AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels.size()) ,
                                           AV51Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                           Integer.valueOf(AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels.size()) ,
                                           AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                           Integer.valueOf(AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels.size()) ,
                                           AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV38PaiCod) ,
                                           A1565CliConvenio ,
                                           AV39ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV51Convenio_adicionalcancelawwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV51Convenio_adicionalcancelawwds_1_tfconveadicod), 20, "%") ;
      lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = GXutil.padr( GXutil.rtrim( AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela), 4, "%") ;
      lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = GXutil.concat( GXutil.rtrim( AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes), "%", "") ;
      /* Using cursor P01PY4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV37CliCod), Short.valueOf(AV38PaiCod), AV39ConveCodigo, lV51Convenio_adicionalcancelawwds_1_tfconveadicod, lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela, lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1PY6 = false ;
         A1824ConveAdiSitCancela = P01PY4_A1824ConveAdiSitCancela[0] ;
         A1565CliConvenio = P01PY4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01PY4_A1564CliPaiConve[0] ;
         A3CliCod = P01PY4_A3CliCod[0] ;
         A1825ConveAdiSitCancDes = P01PY4_A1825ConveAdiSitCancDes[0] ;
         A996ConveAdicod = P01PY4_A996ConveAdicod[0] ;
         A1825ConveAdiSitCancDes = P01PY4_A1825ConveAdiSitCancDes[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01PY4_A1824ConveAdiSitCancela[0], A1824ConveAdiSitCancela) == 0 ) )
         {
            brk1PY6 = false ;
            A1565CliConvenio = P01PY4_A1565CliConvenio[0] ;
            A1564CliPaiConve = P01PY4_A1564CliPaiConve[0] ;
            A3CliCod = P01PY4_A3CliCod[0] ;
            A996ConveAdicod = P01PY4_A996ConveAdicod[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1PY6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1825ConveAdiSitCancDes)==0) )
         {
            AV18Option = A1825ConveAdiSitCancDes ;
            AV17InsertIndex = 1 ;
            while ( ( AV17InsertIndex <= AV19Options.size() ) && ( GXutil.strcmp((String)AV19Options.elementAt(-1+AV17InsertIndex), AV18Option) < 0 ) )
            {
               AV17InsertIndex = (int)(AV17InsertIndex+1) ;
            }
            AV19Options.add(AV18Option, AV17InsertIndex);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), AV17InsertIndex);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1PY6 )
         {
            brk1PY6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_adicionalcancelawwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = convenio_adicionalcancelawwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = convenio_adicionalcancelawwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32OptionsJson = "" ;
      AV33OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV41TFConveAdicod = "" ;
      AV40TFConveAdicod_SelsJson = "" ;
      AV42TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFConveAdiSitCancela = "" ;
      AV11TFConveAdiSitCancela_SelsJson = "" ;
      AV13TFConveAdiSitCancela_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFConveAdiSitCancDes = "" ;
      AV14TFConveAdiSitCancDes_SelsJson = "" ;
      AV16TFConveAdiSitCancDes_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46MenuOpcCod = "" ;
      A996ConveAdicod = "" ;
      AV51Convenio_adicionalcancelawwds_1_tfconveadicod = "" ;
      AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = "" ;
      AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = "" ;
      AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV51Convenio_adicionalcancelawwds_1_tfconveadicod = "" ;
      lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela = "" ;
      lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes = "" ;
      A1824ConveAdiSitCancela = "" ;
      A1825ConveAdiSitCancDes = "" ;
      AV39ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P01PY2_A1565CliConvenio = new String[] {""} ;
      P01PY2_A1564CliPaiConve = new short[1] ;
      P01PY2_A3CliCod = new int[1] ;
      P01PY2_A996ConveAdicod = new String[] {""} ;
      P01PY2_A1825ConveAdiSitCancDes = new String[] {""} ;
      P01PY2_A1824ConveAdiSitCancela = new String[] {""} ;
      AV18Option = "" ;
      P01PY3_A1824ConveAdiSitCancela = new String[] {""} ;
      P01PY3_A1565CliConvenio = new String[] {""} ;
      P01PY3_A1564CliPaiConve = new short[1] ;
      P01PY3_A3CliCod = new int[1] ;
      P01PY3_A1825ConveAdiSitCancDes = new String[] {""} ;
      P01PY3_A996ConveAdicod = new String[] {""} ;
      P01PY4_A1824ConveAdiSitCancela = new String[] {""} ;
      P01PY4_A1565CliConvenio = new String[] {""} ;
      P01PY4_A1564CliPaiConve = new short[1] ;
      P01PY4_A3CliCod = new int[1] ;
      P01PY4_A1825ConveAdiSitCancDes = new String[] {""} ;
      P01PY4_A996ConveAdicod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalcancelawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01PY2_A1565CliConvenio, P01PY2_A1564CliPaiConve, P01PY2_A3CliCod, P01PY2_A996ConveAdicod, P01PY2_A1825ConveAdiSitCancDes, P01PY2_A1824ConveAdiSitCancela
            }
            , new Object[] {
            P01PY3_A1824ConveAdiSitCancela, P01PY3_A1565CliConvenio, P01PY3_A1564CliPaiConve, P01PY3_A3CliCod, P01PY3_A1825ConveAdiSitCancDes, P01PY3_A996ConveAdicod
            }
            , new Object[] {
            P01PY4_A1824ConveAdiSitCancela, P01PY4_A1565CliConvenio, P01PY4_A1564CliPaiConve, P01PY4_A3CliCod, P01PY4_A1825ConveAdiSitCancDes, P01PY4_A996ConveAdicod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV38PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV49GXV1 ;
   private int AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size ;
   private int AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size ;
   private int AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size ;
   private int A3CliCod ;
   private int AV17InsertIndex ;
   private long AV23count ;
   private String AV41TFConveAdicod ;
   private String AV12TFConveAdiSitCancela ;
   private String A996ConveAdicod ;
   private String AV51Convenio_adicionalcancelawwds_1_tfconveadicod ;
   private String AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ;
   private String scmdbuf ;
   private String lV51Convenio_adicionalcancelawwds_1_tfconveadicod ;
   private String lV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ;
   private String A1824ConveAdiSitCancela ;
   private String AV39ConveCodigo ;
   private String A1565CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1PY2 ;
   private boolean brk1PY4 ;
   private boolean brk1PY6 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV40TFConveAdicod_SelsJson ;
   private String AV11TFConveAdiSitCancela_SelsJson ;
   private String AV14TFConveAdiSitCancDes_SelsJson ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV15TFConveAdiSitCancDes ;
   private String AV46MenuOpcCod ;
   private String AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ;
   private String lV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ;
   private String A1825ConveAdiSitCancDes ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01PY2_A1565CliConvenio ;
   private short[] P01PY2_A1564CliPaiConve ;
   private int[] P01PY2_A3CliCod ;
   private String[] P01PY2_A996ConveAdicod ;
   private String[] P01PY2_A1825ConveAdiSitCancDes ;
   private String[] P01PY2_A1824ConveAdiSitCancela ;
   private String[] P01PY3_A1824ConveAdiSitCancela ;
   private String[] P01PY3_A1565CliConvenio ;
   private short[] P01PY3_A1564CliPaiConve ;
   private int[] P01PY3_A3CliCod ;
   private String[] P01PY3_A1825ConveAdiSitCancDes ;
   private String[] P01PY3_A996ConveAdicod ;
   private String[] P01PY4_A1824ConveAdiSitCancela ;
   private String[] P01PY4_A1565CliConvenio ;
   private short[] P01PY4_A1564CliPaiConve ;
   private int[] P01PY4_A3CliCod ;
   private String[] P01PY4_A1825ConveAdiSitCancDes ;
   private String[] P01PY4_A996ConveAdicod ;
   private GXSimpleCollection<String> AV42TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV13TFConveAdiSitCancela_Sels ;
   private GXSimpleCollection<String> AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV16TFConveAdiSitCancDes_Sels ;
   private GXSimpleCollection<String> AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class convenio_adicionalcancelawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01PY2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                          String A1824ConveAdiSitCancela ,
                                          GXSimpleCollection<String> AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                          String A1825ConveAdiSitCancDes ,
                                          GXSimpleCollection<String> AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                          int AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size ,
                                          String AV51Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                          int AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size ,
                                          String AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                          int AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size ,
                                          String AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                          int AV37CliCod ,
                                          short AV38PaiCod ,
                                          String AV39ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[6];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.CliConvenio, T1.CliPaiConve, T1.CliCod, T1.ConveAdicod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdiSitCancela AS ConveAdiSitCancela FROM (convenio_adicionalCancela" ;
      scmdbuf += " T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?))");
      if ( ( AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Convenio_adicionalcancelawwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels, "T1.ConveAdicod IN (", ")")+")");
      }
      if ( ( AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdiSitCancela) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels, "T1.ConveAdiSitCancela IN (", ")")+")");
      }
      if ( ( AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels, "T2.SitDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.ConveAdicod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01PY3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                          String A1824ConveAdiSitCancela ,
                                          GXSimpleCollection<String> AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                          String A1825ConveAdiSitCancDes ,
                                          GXSimpleCollection<String> AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                          int AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size ,
                                          String AV51Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                          int AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size ,
                                          String AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                          int AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size ,
                                          String AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                          int A3CliCod ,
                                          int AV37CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV38PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV39ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[6];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.ConveAdiSitCancela AS ConveAdiSitCancela, T1.CliConvenio, T1.CliPaiConve, T1.CliCod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdicod FROM (convenio_adicionalCancela" ;
      scmdbuf += " T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.CliPaiConve = ?)");
      addWhere(sWhereString, "(T1.CliConvenio = ( ?))");
      if ( ( AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Convenio_adicionalcancelawwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels, "T1.ConveAdicod IN (", ")")+")");
      }
      if ( ( AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdiSitCancela) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels, "T1.ConveAdiSitCancela IN (", ")")+")");
      }
      if ( ( AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels, "T2.SitDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConveAdiSitCancela" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01PY4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels ,
                                          String A1824ConveAdiSitCancela ,
                                          GXSimpleCollection<String> AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels ,
                                          String A1825ConveAdiSitCancDes ,
                                          GXSimpleCollection<String> AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels ,
                                          int AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size ,
                                          String AV51Convenio_adicionalcancelawwds_1_tfconveadicod ,
                                          int AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size ,
                                          String AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela ,
                                          int AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size ,
                                          String AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes ,
                                          int A3CliCod ,
                                          int AV37CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV38PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV39ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[6];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.ConveAdiSitCancela AS ConveAdiSitCancela, T1.CliConvenio, T1.CliPaiConve, T1.CliCod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdicod FROM (convenio_adicionalCancela" ;
      scmdbuf += " T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(T1.CliPaiConve = ?)");
      addWhere(sWhereString, "(T1.CliConvenio = ( ?))");
      if ( ( AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Convenio_adicionalcancelawwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Convenio_adicionalcancelawwds_2_tfconveadicod_sels, "T1.ConveAdicod IN (", ")")+")");
      }
      if ( ( AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV53Convenio_adicionalcancelawwds_3_tfconveadisitcancela)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.ConveAdiSitCancela) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Convenio_adicionalcancelawwds_4_tfconveadisitcancela_sels, "T1.ConveAdiSitCancela IN (", ")")+")");
      }
      if ( ( AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Convenio_adicionalcancelawwds_5_tfconveadisitcancdes)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.SitDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Convenio_adicionalcancelawwds_6_tfconveadisitcancdes_sels, "T2.SitDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.ConveAdiSitCancela" ;
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
                  return conditional_P01PY2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).shortValue() , (String)dynConstraints[17] );
            case 1 :
                  return conditional_P01PY3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] );
            case 2 :
                  return conditional_P01PY4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).shortValue() , (String)dynConstraints[16] , (String)dynConstraints[17] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01PY2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PY3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01PY4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
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
                  stmt.setString(sIdx, (String)parms[10], 4);
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
                  stmt.setString(sIdx, (String)parms[10], 4);
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
                  stmt.setString(sIdx, (String)parms[10], 4);
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

