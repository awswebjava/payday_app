package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esquemacategoriawwgetfilterdata extends GXProcedure
{
   public esquemacategoriawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemacategoriawwgetfilterdata.class ), "" );
   }

   public esquemacategoriawwgetfilterdata( int remoteHandle ,
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
      esquemacategoriawwgetfilterdata.this.aP5 = new String[] {""};
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
      esquemacategoriawwgetfilterdata.this.AV35DDOName = aP0;
      esquemacategoriawwgetfilterdata.this.AV36SearchTxt = aP1;
      esquemacategoriawwgetfilterdata.this.AV37SearchTxtTo = aP2;
      esquemacategoriawwgetfilterdata.this.aP3 = aP3;
      esquemacategoriawwgetfilterdata.this.aP4 = aP4;
      esquemacategoriawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV42EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      esquemacategoriawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV42EmpCod = GXt_int1 ;
      GXt_int3 = AV43CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      esquemacategoriawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV43CliCod = GXt_int3 ;
      AV25Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaCategoria", GXv_boolean6) ;
      esquemacategoriawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_CATCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADCATCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV35DDOName), "DDO_CATDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCATDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV38OptionsJson = AV25Options.toJSonString(false) ;
      AV39OptionsDescJson = AV27OptionsDesc.toJSonString(false) ;
      AV40OptionIndexesJson = AV28OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("EsquemaCategoriaWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EsquemaCategoriaWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("EsquemaCategoriaWWGridState"), null, null);
      }
      AV47GXV1 = 1 ;
      while ( AV47GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV47GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO") == 0 )
         {
            AV12TFCatCodigo = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCODIGO_SEL") == 0 )
         {
            AV11TFCatCodigo_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFCatCodigo_Sels.fromJSonString(AV11TFCatCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP") == 0 )
         {
            AV15TFCatDescrip = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATDESCRIP_SEL") == 0 )
         {
            AV14TFCatDescrip_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFCatDescrip_Sels.fromJSonString(AV14TFCatDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATCLASE_SEL") == 0 )
         {
            AV17TFCatClase_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV18TFCatClase_Sels.fromJSonString(AV17TFCatClase_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATTIPOTARIFA_SEL") == 0 )
         {
            AV19TFCatTipoTarifa_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFCatTipoTarifa_Sels.fromJSonString(AV19TFCatTipoTarifa_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCATFRECACT") == 0 )
         {
            AV21TFCatFrecAct = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV22TFCatFrecAct_To = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICONVENIO") == 0 )
         {
            AV44CliConvenio = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV47GXV1 = (int)(AV47GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCATCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV12TFCatCodigo = AV36SearchTxt ;
      AV13TFCatCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Esquemacategoriawwds_1_tfcatcodigo = AV12TFCatCodigo ;
      AV50Esquemacategoriawwds_2_tfcatcodigo_sels = AV13TFCatCodigo_Sels ;
      AV51Esquemacategoriawwds_3_tfcatdescrip = AV15TFCatDescrip ;
      AV52Esquemacategoriawwds_4_tfcatdescrip_sels = AV16TFCatDescrip_Sels ;
      AV53Esquemacategoriawwds_5_tfcatclase_sels = AV18TFCatClase_Sels ;
      AV54Esquemacategoriawwds_6_tfcattipotarifa_sels = AV20TFCatTipoTarifa_Sels ;
      AV55Esquemacategoriawwds_7_tfcatfrecact = AV21TFCatFrecAct ;
      AV56Esquemacategoriawwds_8_tfcatfrecact_to = AV22TFCatFrecAct_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A8CatCodigo ,
                                           AV50Esquemacategoriawwds_2_tfcatcodigo_sels ,
                                           A123CatDescrip ,
                                           AV52Esquemacategoriawwds_4_tfcatdescrip_sels ,
                                           Byte.valueOf(A1838CatClase) ,
                                           AV53Esquemacategoriawwds_5_tfcatclase_sels ,
                                           A2416CatTipoTarifa ,
                                           AV54Esquemacategoriawwds_6_tfcattipotarifa_sels ,
                                           Integer.valueOf(AV50Esquemacategoriawwds_2_tfcatcodigo_sels.size()) ,
                                           AV49Esquemacategoriawwds_1_tfcatcodigo ,
                                           Integer.valueOf(AV52Esquemacategoriawwds_4_tfcatdescrip_sels.size()) ,
                                           AV51Esquemacategoriawwds_3_tfcatdescrip ,
                                           Integer.valueOf(AV53Esquemacategoriawwds_5_tfcatclase_sels.size()) ,
                                           Integer.valueOf(AV54Esquemacategoriawwds_6_tfcattipotarifa_sels.size()) ,
                                           Byte.valueOf(AV55Esquemacategoriawwds_7_tfcatfrecact) ,
                                           Byte.valueOf(AV56Esquemacategoriawwds_8_tfcatfrecact_to) ,
                                           Byte.valueOf(A1914CatFrecAct) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV43CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV49Esquemacategoriawwds_1_tfcatcodigo = GXutil.padr( GXutil.rtrim( AV49Esquemacategoriawwds_1_tfcatcodigo), 40, "%") ;
      lV51Esquemacategoriawwds_3_tfcatdescrip = GXutil.concat( GXutil.rtrim( AV51Esquemacategoriawwds_3_tfcatdescrip), "%", "") ;
      /* Using cursor P02LT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV43CliCod), lV49Esquemacategoriawwds_1_tfcatcodigo, lV51Esquemacategoriawwds_3_tfcatdescrip, Byte.valueOf(AV55Esquemacategoriawwds_7_tfcatfrecact), Byte.valueOf(AV56Esquemacategoriawwds_8_tfcatfrecact_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2LT2 = false ;
         A3CliCod = P02LT2_A3CliCod[0] ;
         A8CatCodigo = P02LT2_A8CatCodigo[0] ;
         A1914CatFrecAct = P02LT2_A1914CatFrecAct[0] ;
         A2416CatTipoTarifa = P02LT2_A2416CatTipoTarifa[0] ;
         A1838CatClase = P02LT2_A1838CatClase[0] ;
         A123CatDescrip = P02LT2_A123CatDescrip[0] ;
         A1564CliPaiConve = P02LT2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02LT2_A1565CliConvenio[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P02LT2_A8CatCodigo[0], A8CatCodigo) == 0 ) )
         {
            brk2LT2 = false ;
            A3CliCod = P02LT2_A3CliCod[0] ;
            A1564CliPaiConve = P02LT2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P02LT2_A1565CliConvenio[0] ;
            AV29count = (long)(AV29count+1) ;
            brk2LT2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A8CatCodigo)==0) )
         {
            AV24Option = A8CatCodigo ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2LT2 )
         {
            brk2LT2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCATDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFCatDescrip = AV36SearchTxt ;
      AV16TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV49Esquemacategoriawwds_1_tfcatcodigo = AV12TFCatCodigo ;
      AV50Esquemacategoriawwds_2_tfcatcodigo_sels = AV13TFCatCodigo_Sels ;
      AV51Esquemacategoriawwds_3_tfcatdescrip = AV15TFCatDescrip ;
      AV52Esquemacategoriawwds_4_tfcatdescrip_sels = AV16TFCatDescrip_Sels ;
      AV53Esquemacategoriawwds_5_tfcatclase_sels = AV18TFCatClase_Sels ;
      AV54Esquemacategoriawwds_6_tfcattipotarifa_sels = AV20TFCatTipoTarifa_Sels ;
      AV55Esquemacategoriawwds_7_tfcatfrecact = AV21TFCatFrecAct ;
      AV56Esquemacategoriawwds_8_tfcatfrecact_to = AV22TFCatFrecAct_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A8CatCodigo ,
                                           AV50Esquemacategoriawwds_2_tfcatcodigo_sels ,
                                           A123CatDescrip ,
                                           AV52Esquemacategoriawwds_4_tfcatdescrip_sels ,
                                           Byte.valueOf(A1838CatClase) ,
                                           AV53Esquemacategoriawwds_5_tfcatclase_sels ,
                                           A2416CatTipoTarifa ,
                                           AV54Esquemacategoriawwds_6_tfcattipotarifa_sels ,
                                           Integer.valueOf(AV50Esquemacategoriawwds_2_tfcatcodigo_sels.size()) ,
                                           AV49Esquemacategoriawwds_1_tfcatcodigo ,
                                           Integer.valueOf(AV52Esquemacategoriawwds_4_tfcatdescrip_sels.size()) ,
                                           AV51Esquemacategoriawwds_3_tfcatdescrip ,
                                           Integer.valueOf(AV53Esquemacategoriawwds_5_tfcatclase_sels.size()) ,
                                           Integer.valueOf(AV54Esquemacategoriawwds_6_tfcattipotarifa_sels.size()) ,
                                           Byte.valueOf(AV55Esquemacategoriawwds_7_tfcatfrecact) ,
                                           Byte.valueOf(AV56Esquemacategoriawwds_8_tfcatfrecact_to) ,
                                           Byte.valueOf(A1914CatFrecAct) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV43CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV49Esquemacategoriawwds_1_tfcatcodigo = GXutil.padr( GXutil.rtrim( AV49Esquemacategoriawwds_1_tfcatcodigo), 40, "%") ;
      lV51Esquemacategoriawwds_3_tfcatdescrip = GXutil.concat( GXutil.rtrim( AV51Esquemacategoriawwds_3_tfcatdescrip), "%", "") ;
      /* Using cursor P02LT3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV43CliCod), lV49Esquemacategoriawwds_1_tfcatcodigo, lV51Esquemacategoriawwds_3_tfcatdescrip, Byte.valueOf(AV55Esquemacategoriawwds_7_tfcatfrecact), Byte.valueOf(AV56Esquemacategoriawwds_8_tfcatfrecact_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2LT4 = false ;
         A3CliCod = P02LT3_A3CliCod[0] ;
         A123CatDescrip = P02LT3_A123CatDescrip[0] ;
         A1914CatFrecAct = P02LT3_A1914CatFrecAct[0] ;
         A2416CatTipoTarifa = P02LT3_A2416CatTipoTarifa[0] ;
         A1838CatClase = P02LT3_A1838CatClase[0] ;
         A8CatCodigo = P02LT3_A8CatCodigo[0] ;
         A1564CliPaiConve = P02LT3_A1564CliPaiConve[0] ;
         A1565CliConvenio = P02LT3_A1565CliConvenio[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P02LT3_A123CatDescrip[0], A123CatDescrip) == 0 ) )
         {
            brk2LT4 = false ;
            A3CliCod = P02LT3_A3CliCod[0] ;
            A8CatCodigo = P02LT3_A8CatCodigo[0] ;
            A1564CliPaiConve = P02LT3_A1564CliPaiConve[0] ;
            A1565CliConvenio = P02LT3_A1565CliConvenio[0] ;
            AV29count = (long)(AV29count+1) ;
            brk2LT4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A123CatDescrip)==0) )
         {
            AV24Option = A123CatDescrip ;
            AV25Options.add(AV24Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV25Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2LT4 )
         {
            brk2LT4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = esquemacategoriawwgetfilterdata.this.AV38OptionsJson;
      this.aP4[0] = esquemacategoriawwgetfilterdata.this.AV39OptionsDescJson;
      this.aP5[0] = esquemacategoriawwgetfilterdata.this.AV40OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV38OptionsJson = "" ;
      AV39OptionsDescJson = "" ;
      AV40OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV25Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFCatCodigo = "" ;
      AV11TFCatCodigo_SelsJson = "" ;
      AV13TFCatCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFCatDescrip = "" ;
      AV14TFCatDescrip_SelsJson = "" ;
      AV16TFCatDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17TFCatClase_SelsJson = "" ;
      AV18TFCatClase_Sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV19TFCatTipoTarifa_SelsJson = "" ;
      AV20TFCatTipoTarifa_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      AV44CliConvenio = "" ;
      A8CatCodigo = "" ;
      AV49Esquemacategoriawwds_1_tfcatcodigo = "" ;
      AV50Esquemacategoriawwds_2_tfcatcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV51Esquemacategoriawwds_3_tfcatdescrip = "" ;
      AV52Esquemacategoriawwds_4_tfcatdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV53Esquemacategoriawwds_5_tfcatclase_sels = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV54Esquemacategoriawwds_6_tfcattipotarifa_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV49Esquemacategoriawwds_1_tfcatcodigo = "" ;
      lV51Esquemacategoriawwds_3_tfcatdescrip = "" ;
      A123CatDescrip = "" ;
      A2416CatTipoTarifa = "" ;
      P02LT2_A3CliCod = new int[1] ;
      P02LT2_A8CatCodigo = new String[] {""} ;
      P02LT2_A1914CatFrecAct = new byte[1] ;
      P02LT2_A2416CatTipoTarifa = new String[] {""} ;
      P02LT2_A1838CatClase = new byte[1] ;
      P02LT2_A123CatDescrip = new String[] {""} ;
      P02LT2_A1564CliPaiConve = new short[1] ;
      P02LT2_A1565CliConvenio = new String[] {""} ;
      A1565CliConvenio = "" ;
      AV24Option = "" ;
      P02LT3_A3CliCod = new int[1] ;
      P02LT3_A123CatDescrip = new String[] {""} ;
      P02LT3_A1914CatFrecAct = new byte[1] ;
      P02LT3_A2416CatTipoTarifa = new String[] {""} ;
      P02LT3_A1838CatClase = new byte[1] ;
      P02LT3_A8CatCodigo = new String[] {""} ;
      P02LT3_A1564CliPaiConve = new short[1] ;
      P02LT3_A1565CliConvenio = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemacategoriawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02LT2_A3CliCod, P02LT2_A8CatCodigo, P02LT2_A1914CatFrecAct, P02LT2_A2416CatTipoTarifa, P02LT2_A1838CatClase, P02LT2_A123CatDescrip, P02LT2_A1564CliPaiConve, P02LT2_A1565CliConvenio
            }
            , new Object[] {
            P02LT3_A3CliCod, P02LT3_A123CatDescrip, P02LT3_A1914CatFrecAct, P02LT3_A2416CatTipoTarifa, P02LT3_A1838CatClase, P02LT3_A8CatCodigo, P02LT3_A1564CliPaiConve, P02LT3_A1565CliConvenio
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV21TFCatFrecAct ;
   private byte AV22TFCatFrecAct_To ;
   private byte AV55Esquemacategoriawwds_7_tfcatfrecact ;
   private byte AV56Esquemacategoriawwds_8_tfcatfrecact_to ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private short AV42EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV43CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV47GXV1 ;
   private int AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size ;
   private int AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size ;
   private int AV53Esquemacategoriawwds_5_tfcatclase_sels_size ;
   private int AV54Esquemacategoriawwds_6_tfcattipotarifa_sels_size ;
   private int A3CliCod ;
   private long AV29count ;
   private String AV12TFCatCodigo ;
   private String AV44CliConvenio ;
   private String A8CatCodigo ;
   private String AV49Esquemacategoriawwds_1_tfcatcodigo ;
   private String scmdbuf ;
   private String lV49Esquemacategoriawwds_1_tfcatcodigo ;
   private String A2416CatTipoTarifa ;
   private String A1565CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk2LT2 ;
   private boolean brk2LT4 ;
   private String AV38OptionsJson ;
   private String AV39OptionsDescJson ;
   private String AV40OptionIndexesJson ;
   private String AV11TFCatCodigo_SelsJson ;
   private String AV14TFCatDescrip_SelsJson ;
   private String AV17TFCatClase_SelsJson ;
   private String AV19TFCatTipoTarifa_SelsJson ;
   private String AV35DDOName ;
   private String AV36SearchTxt ;
   private String AV37SearchTxtTo ;
   private String AV15TFCatDescrip ;
   private String AV41MenuOpcCod ;
   private String AV51Esquemacategoriawwds_3_tfcatdescrip ;
   private String lV51Esquemacategoriawwds_3_tfcatdescrip ;
   private String A123CatDescrip ;
   private String AV24Option ;
   private GXSimpleCollection<Byte> AV18TFCatClase_Sels ;
   private GXSimpleCollection<Byte> AV53Esquemacategoriawwds_5_tfcatclase_sels ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P02LT2_A3CliCod ;
   private String[] P02LT2_A8CatCodigo ;
   private byte[] P02LT2_A1914CatFrecAct ;
   private String[] P02LT2_A2416CatTipoTarifa ;
   private byte[] P02LT2_A1838CatClase ;
   private String[] P02LT2_A123CatDescrip ;
   private short[] P02LT2_A1564CliPaiConve ;
   private String[] P02LT2_A1565CliConvenio ;
   private int[] P02LT3_A3CliCod ;
   private String[] P02LT3_A123CatDescrip ;
   private byte[] P02LT3_A1914CatFrecAct ;
   private String[] P02LT3_A2416CatTipoTarifa ;
   private byte[] P02LT3_A1838CatClase ;
   private String[] P02LT3_A8CatCodigo ;
   private short[] P02LT3_A1564CliPaiConve ;
   private String[] P02LT3_A1565CliConvenio ;
   private GXSimpleCollection<String> AV13TFCatCodigo_Sels ;
   private GXSimpleCollection<String> AV20TFCatTipoTarifa_Sels ;
   private GXSimpleCollection<String> AV50Esquemacategoriawwds_2_tfcatcodigo_sels ;
   private GXSimpleCollection<String> AV54Esquemacategoriawwds_6_tfcattipotarifa_sels ;
   private GXSimpleCollection<String> AV25Options ;
   private GXSimpleCollection<String> AV27OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV16TFCatDescrip_Sels ;
   private GXSimpleCollection<String> AV52Esquemacategoriawwds_4_tfcatdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class esquemacategoriawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02LT2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A8CatCodigo ,
                                          GXSimpleCollection<String> AV50Esquemacategoriawwds_2_tfcatcodigo_sels ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV52Esquemacategoriawwds_4_tfcatdescrip_sels ,
                                          byte A1838CatClase ,
                                          GXSimpleCollection<Byte> AV53Esquemacategoriawwds_5_tfcatclase_sels ,
                                          String A2416CatTipoTarifa ,
                                          GXSimpleCollection<String> AV54Esquemacategoriawwds_6_tfcattipotarifa_sels ,
                                          int AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size ,
                                          String AV49Esquemacategoriawwds_1_tfcatcodigo ,
                                          int AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size ,
                                          String AV51Esquemacategoriawwds_3_tfcatdescrip ,
                                          int AV53Esquemacategoriawwds_5_tfcatclase_sels_size ,
                                          int AV54Esquemacategoriawwds_6_tfcattipotarifa_sels_size ,
                                          byte AV55Esquemacategoriawwds_7_tfcatfrecact ,
                                          byte AV56Esquemacategoriawwds_8_tfcatfrecact_to ,
                                          byte A1914CatFrecAct ,
                                          int A3CliCod ,
                                          int AV43CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, CatCodigo, CatFrecAct, CatTipoTarifa, CatClase, CatDescrip, CliPaiConve, CliConvenio FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Esquemacategoriawwds_1_tfcatcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Esquemacategoriawwds_2_tfcatcodigo_sels, "CatCodigo IN (", ")")+")");
      }
      if ( ( AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Esquemacategoriawwds_3_tfcatdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Esquemacategoriawwds_4_tfcatdescrip_sels, "CatDescrip IN (", ")")+")");
      }
      if ( AV53Esquemacategoriawwds_5_tfcatclase_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Esquemacategoriawwds_5_tfcatclase_sels, "CatClase IN (", ")")+")");
      }
      if ( AV54Esquemacategoriawwds_6_tfcattipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Esquemacategoriawwds_6_tfcattipotarifa_sels, "CatTipoTarifa IN (", ")")+")");
      }
      if ( ! (0==AV55Esquemacategoriawwds_7_tfcatfrecact) )
      {
         addWhere(sWhereString, "(CatFrecAct >= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV56Esquemacategoriawwds_8_tfcatfrecact_to) )
      {
         addWhere(sWhereString, "(CatFrecAct <= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CatCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02LT3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A8CatCodigo ,
                                          GXSimpleCollection<String> AV50Esquemacategoriawwds_2_tfcatcodigo_sels ,
                                          String A123CatDescrip ,
                                          GXSimpleCollection<String> AV52Esquemacategoriawwds_4_tfcatdescrip_sels ,
                                          byte A1838CatClase ,
                                          GXSimpleCollection<Byte> AV53Esquemacategoriawwds_5_tfcatclase_sels ,
                                          String A2416CatTipoTarifa ,
                                          GXSimpleCollection<String> AV54Esquemacategoriawwds_6_tfcattipotarifa_sels ,
                                          int AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size ,
                                          String AV49Esquemacategoriawwds_1_tfcatcodigo ,
                                          int AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size ,
                                          String AV51Esquemacategoriawwds_3_tfcatdescrip ,
                                          int AV53Esquemacategoriawwds_5_tfcatclase_sels_size ,
                                          int AV54Esquemacategoriawwds_6_tfcattipotarifa_sels_size ,
                                          byte AV55Esquemacategoriawwds_7_tfcatfrecact ,
                                          byte AV56Esquemacategoriawwds_8_tfcatfrecact_to ,
                                          byte A1914CatFrecAct ,
                                          int A3CliCod ,
                                          int AV43CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CatDescrip, CatFrecAct, CatTipoTarifa, CatClase, CatCodigo, CliPaiConve, CliConvenio FROM Categoria1" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Esquemacategoriawwds_1_tfcatcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV50Esquemacategoriawwds_2_tfcatcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Esquemacategoriawwds_2_tfcatcodigo_sels, "CatCodigo IN (", ")")+")");
      }
      if ( ( AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV51Esquemacategoriawwds_3_tfcatdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(CatDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV52Esquemacategoriawwds_4_tfcatdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV52Esquemacategoriawwds_4_tfcatdescrip_sels, "CatDescrip IN (", ")")+")");
      }
      if ( AV53Esquemacategoriawwds_5_tfcatclase_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Esquemacategoriawwds_5_tfcatclase_sels, "CatClase IN (", ")")+")");
      }
      if ( AV54Esquemacategoriawwds_6_tfcattipotarifa_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV54Esquemacategoriawwds_6_tfcattipotarifa_sels, "CatTipoTarifa IN (", ")")+")");
      }
      if ( ! (0==AV55Esquemacategoriawwds_7_tfcatfrecact) )
      {
         addWhere(sWhereString, "(CatFrecAct >= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV56Esquemacategoriawwds_8_tfcatfrecact_to) )
      {
         addWhere(sWhereString, "(CatFrecAct <= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CatDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
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
                  return conditional_P02LT2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() );
            case 1 :
                  return conditional_P02LT3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).byteValue() , (GXSimpleCollection<Byte>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).byteValue() , ((Number) dynConstraints[15]).byteValue() , ((Number) dynConstraints[16]).byteValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02LT2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02LT3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 1);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[8]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
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
                  stmt.setString(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[8]).byteValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setByte(sIdx, ((Number) parms[9]).byteValue());
               }
               return;
      }
   }

}

