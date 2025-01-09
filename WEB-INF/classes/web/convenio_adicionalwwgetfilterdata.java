package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicionalwwgetfilterdata extends GXProcedure
{
   public convenio_adicionalwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalwwgetfilterdata.class ), "" );
   }

   public convenio_adicionalwwgetfilterdata( int remoteHandle ,
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
      convenio_adicionalwwgetfilterdata.this.aP5 = new String[] {""};
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
      convenio_adicionalwwgetfilterdata.this.AV37DDOName = aP0;
      convenio_adicionalwwgetfilterdata.this.AV38SearchTxt = aP1;
      convenio_adicionalwwgetfilterdata.this.AV39SearchTxtTo = aP2;
      convenio_adicionalwwgetfilterdata.this.aP3 = aP3;
      convenio_adicionalwwgetfilterdata.this.aP4 = aP4;
      convenio_adicionalwwgetfilterdata.this.aP5 = aP5;
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
      convenio_adicionalwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV44EmpCod = GXt_int1 ;
      GXt_int3 = AV45CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      convenio_adicionalwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV45CliCod = GXt_int3 ;
      AV27Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV30OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional", GXv_boolean6) ;
      convenio_adicionalwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONVEADICOD") == 0 )
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
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONVEADIDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADIDESCRIOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV37DDOName), "DDO_CONVEADIINFO") == 0 )
         {
            /* Execute user subroutine: 'LOADCONVEADIINFOOPTIONS' */
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
      if ( GXutil.strcmp(AV32Session.getValue("convenio_adicionalWWGridState"), "") == 0 )
      {
         AV34GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "convenio_adicionalWWGridState"), null, null);
      }
      else
      {
         AV34GridState.fromxml(AV32Session.getValue("convenio_adicionalWWGridState"), null, null);
      }
      AV65GXV1 = 1 ;
      while ( AV65GXV1 <= AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV35GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV34GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV65GXV1));
         if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD") == 0 )
         {
            AV15TFConveAdicod = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADICOD_SEL") == 0 )
         {
            AV14TFConveAdicod_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFConveAdicod_Sels.fromJSonString(AV14TFConveAdicod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIDESCRI") == 0 )
         {
            AV18TFConveAdiDescri = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIDESCRI_SEL") == 0 )
         {
            AV17TFConveAdiDescri_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV19TFConveAdiDescri_Sels.fromJSonString(AV17TFConveAdiDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIALI") == 0 )
         {
            AV20TFConveAdiAli = CommonUtil.decimalVal( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            AV21TFConveAdiAli_To = CommonUtil.decimalVal( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIINFO") == 0 )
         {
            AV23TFConveAdiInfo = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIINFO_SEL") == 0 )
         {
            AV22TFConveAdiInfo_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV24TFConveAdiInfo_Sels.fromJSonString(AV22TFConveAdiInfo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADITIPO_SEL") == 0 )
         {
            AV49TFConveAdiTipo_SelsJson = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFConveAdiTipo_Sels.fromJSonString(AV49TFConveAdiTipo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCONVEADIRELSEC") == 0 )
         {
            AV51TFConveAdiRelSec = (int)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV52TFConveAdiRelSec_To = (int)(GXutil.lval( AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV62MenuOpcCod = AV35GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV65GXV1 = (int)(AV65GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCONVEADICODOPTIONS' Routine */
      returnInSub = false ;
      AV15TFConveAdicod = AV38SearchTxt ;
      AV16TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV67Convenio_adicionalwwds_1_tfconveadicod = AV15TFConveAdicod ;
      AV68Convenio_adicionalwwds_2_tfconveadicod_sels = AV16TFConveAdicod_Sels ;
      AV69Convenio_adicionalwwds_3_tfconveadidescri = AV18TFConveAdiDescri ;
      AV70Convenio_adicionalwwds_4_tfconveadidescri_sels = AV19TFConveAdiDescri_Sels ;
      AV71Convenio_adicionalwwds_5_tfconveadiali = AV20TFConveAdiAli ;
      AV72Convenio_adicionalwwds_6_tfconveadiali_to = AV21TFConveAdiAli_To ;
      AV73Convenio_adicionalwwds_7_tfconveadiinfo = AV23TFConveAdiInfo ;
      AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels = AV24TFConveAdiInfo_Sels ;
      AV75Convenio_adicionalwwds_9_tfconveaditipo_sels = AV50TFConveAdiTipo_Sels ;
      AV76Convenio_adicionalwwds_10_tfconveadirelsec = AV51TFConveAdiRelSec ;
      AV77Convenio_adicionalwwds_11_tfconveadirelsec_to = AV52TFConveAdiRelSec_To ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV68Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                           A997ConveAdiDescri ,
                                           AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                           A1019ConveAdiInfo ,
                                           AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                           A1803ConveAdiTipo ,
                                           AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                           Integer.valueOf(AV68Convenio_adicionalwwds_2_tfconveadicod_sels.size()) ,
                                           AV67Convenio_adicionalwwds_1_tfconveadicod ,
                                           Integer.valueOf(AV70Convenio_adicionalwwds_4_tfconveadidescri_sels.size()) ,
                                           AV69Convenio_adicionalwwds_3_tfconveadidescri ,
                                           AV71Convenio_adicionalwwds_5_tfconveadiali ,
                                           AV72Convenio_adicionalwwds_6_tfconveadiali_to ,
                                           Integer.valueOf(AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels.size()) ,
                                           AV73Convenio_adicionalwwds_7_tfconveadiinfo ,
                                           Integer.valueOf(AV75Convenio_adicionalwwds_9_tfconveaditipo_sels.size()) ,
                                           Integer.valueOf(AV76Convenio_adicionalwwds_10_tfconveadirelsec) ,
                                           Integer.valueOf(AV77Convenio_adicionalwwds_11_tfconveadirelsec_to) ,
                                           A998ConveAdiAli ,
                                           Integer.valueOf(A1901ConveAdiRelSec) ,
                                           Integer.valueOf(AV45CliCod) ,
                                           Short.valueOf(AV46PaiCod) ,
                                           AV48ConveCodigo ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING
                                           }
      });
      lV67Convenio_adicionalwwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV67Convenio_adicionalwwds_1_tfconveadicod), 20, "%") ;
      lV69Convenio_adicionalwwds_3_tfconveadidescri = GXutil.concat( GXutil.rtrim( AV69Convenio_adicionalwwds_3_tfconveadidescri), "%", "") ;
      lV73Convenio_adicionalwwds_7_tfconveadiinfo = GXutil.concat( GXutil.rtrim( AV73Convenio_adicionalwwds_7_tfconveadiinfo), "%", "") ;
      /* Using cursor P01FX2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV45CliCod), Short.valueOf(AV46PaiCod), AV48ConveCodigo, lV67Convenio_adicionalwwds_1_tfconveadicod, lV69Convenio_adicionalwwds_3_tfconveadidescri, AV71Convenio_adicionalwwds_5_tfconveadiali, AV72Convenio_adicionalwwds_6_tfconveadiali_to, lV73Convenio_adicionalwwds_7_tfconveadiinfo, Integer.valueOf(AV76Convenio_adicionalwwds_10_tfconveadirelsec), Integer.valueOf(AV77Convenio_adicionalwwds_11_tfconveadirelsec_to)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1FX2 = false ;
         A1565CliConvenio = P01FX2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01FX2_A1564CliPaiConve[0] ;
         A3CliCod = P01FX2_A3CliCod[0] ;
         A996ConveAdicod = P01FX2_A996ConveAdicod[0] ;
         A1901ConveAdiRelSec = P01FX2_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = P01FX2_n1901ConveAdiRelSec[0] ;
         A1803ConveAdiTipo = P01FX2_A1803ConveAdiTipo[0] ;
         A1019ConveAdiInfo = P01FX2_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = P01FX2_n1019ConveAdiInfo[0] ;
         A998ConveAdiAli = P01FX2_A998ConveAdiAli[0] ;
         A997ConveAdiDescri = P01FX2_A997ConveAdiDescri[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01FX2_A3CliCod[0] == A3CliCod ) && ( P01FX2_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01FX2_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( GXutil.strcmp(P01FX2_A996ConveAdicod[0], A996ConveAdicod) == 0 ) )
         {
            brk1FX2 = false ;
            AV31count = (long)(AV31count+1) ;
            brk1FX2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A996ConveAdicod)==0) )
         {
            AV26Option = A996ConveAdicod ;
            AV27Options.add(AV26Option, 0);
            AV30OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV27Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1FX2 )
         {
            brk1FX2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCONVEADIDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV18TFConveAdiDescri = AV38SearchTxt ;
      AV19TFConveAdiDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV67Convenio_adicionalwwds_1_tfconveadicod = AV15TFConveAdicod ;
      AV68Convenio_adicionalwwds_2_tfconveadicod_sels = AV16TFConveAdicod_Sels ;
      AV69Convenio_adicionalwwds_3_tfconveadidescri = AV18TFConveAdiDescri ;
      AV70Convenio_adicionalwwds_4_tfconveadidescri_sels = AV19TFConveAdiDescri_Sels ;
      AV71Convenio_adicionalwwds_5_tfconveadiali = AV20TFConveAdiAli ;
      AV72Convenio_adicionalwwds_6_tfconveadiali_to = AV21TFConveAdiAli_To ;
      AV73Convenio_adicionalwwds_7_tfconveadiinfo = AV23TFConveAdiInfo ;
      AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels = AV24TFConveAdiInfo_Sels ;
      AV75Convenio_adicionalwwds_9_tfconveaditipo_sels = AV50TFConveAdiTipo_Sels ;
      AV76Convenio_adicionalwwds_10_tfconveadirelsec = AV51TFConveAdiRelSec ;
      AV77Convenio_adicionalwwds_11_tfconveadirelsec_to = AV52TFConveAdiRelSec_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV68Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                           A997ConveAdiDescri ,
                                           AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                           A1019ConveAdiInfo ,
                                           AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                           A1803ConveAdiTipo ,
                                           AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                           Integer.valueOf(AV68Convenio_adicionalwwds_2_tfconveadicod_sels.size()) ,
                                           AV67Convenio_adicionalwwds_1_tfconveadicod ,
                                           Integer.valueOf(AV70Convenio_adicionalwwds_4_tfconveadidescri_sels.size()) ,
                                           AV69Convenio_adicionalwwds_3_tfconveadidescri ,
                                           AV71Convenio_adicionalwwds_5_tfconveadiali ,
                                           AV72Convenio_adicionalwwds_6_tfconveadiali_to ,
                                           Integer.valueOf(AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels.size()) ,
                                           AV73Convenio_adicionalwwds_7_tfconveadiinfo ,
                                           Integer.valueOf(AV75Convenio_adicionalwwds_9_tfconveaditipo_sels.size()) ,
                                           Integer.valueOf(AV76Convenio_adicionalwwds_10_tfconveadirelsec) ,
                                           Integer.valueOf(AV77Convenio_adicionalwwds_11_tfconveadirelsec_to) ,
                                           A998ConveAdiAli ,
                                           Integer.valueOf(A1901ConveAdiRelSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV45CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV46PaiCod) ,
                                           A1565CliConvenio ,
                                           AV48ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV67Convenio_adicionalwwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV67Convenio_adicionalwwds_1_tfconveadicod), 20, "%") ;
      lV69Convenio_adicionalwwds_3_tfconveadidescri = GXutil.concat( GXutil.rtrim( AV69Convenio_adicionalwwds_3_tfconveadidescri), "%", "") ;
      lV73Convenio_adicionalwwds_7_tfconveadiinfo = GXutil.concat( GXutil.rtrim( AV73Convenio_adicionalwwds_7_tfconveadiinfo), "%", "") ;
      /* Using cursor P01FX3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV45CliCod), Short.valueOf(AV46PaiCod), AV48ConveCodigo, lV67Convenio_adicionalwwds_1_tfconveadicod, lV69Convenio_adicionalwwds_3_tfconveadidescri, AV71Convenio_adicionalwwds_5_tfconveadiali, AV72Convenio_adicionalwwds_6_tfconveadiali_to, lV73Convenio_adicionalwwds_7_tfconveadiinfo, Integer.valueOf(AV76Convenio_adicionalwwds_10_tfconveadirelsec), Integer.valueOf(AV77Convenio_adicionalwwds_11_tfconveadirelsec_to)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1FX4 = false ;
         A3CliCod = P01FX3_A3CliCod[0] ;
         A1564CliPaiConve = P01FX3_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01FX3_A1565CliConvenio[0] ;
         A997ConveAdiDescri = P01FX3_A997ConveAdiDescri[0] ;
         A1901ConveAdiRelSec = P01FX3_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = P01FX3_n1901ConveAdiRelSec[0] ;
         A1803ConveAdiTipo = P01FX3_A1803ConveAdiTipo[0] ;
         A1019ConveAdiInfo = P01FX3_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = P01FX3_n1019ConveAdiInfo[0] ;
         A998ConveAdiAli = P01FX3_A998ConveAdiAli[0] ;
         A996ConveAdicod = P01FX3_A996ConveAdicod[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P01FX3_A997ConveAdiDescri[0], A997ConveAdiDescri) == 0 ) )
         {
            brk1FX4 = false ;
            A3CliCod = P01FX3_A3CliCod[0] ;
            A1564CliPaiConve = P01FX3_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01FX3_A1565CliConvenio[0] ;
            A996ConveAdicod = P01FX3_A996ConveAdicod[0] ;
            AV31count = (long)(AV31count+1) ;
            brk1FX4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A997ConveAdiDescri)==0) )
         {
            AV26Option = A997ConveAdiDescri ;
            AV27Options.add(AV26Option, 0);
            AV30OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV27Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1FX4 )
         {
            brk1FX4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADCONVEADIINFOOPTIONS' Routine */
      returnInSub = false ;
      AV23TFConveAdiInfo = AV38SearchTxt ;
      AV24TFConveAdiInfo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV67Convenio_adicionalwwds_1_tfconveadicod = AV15TFConveAdicod ;
      AV68Convenio_adicionalwwds_2_tfconveadicod_sels = AV16TFConveAdicod_Sels ;
      AV69Convenio_adicionalwwds_3_tfconveadidescri = AV18TFConveAdiDescri ;
      AV70Convenio_adicionalwwds_4_tfconveadidescri_sels = AV19TFConveAdiDescri_Sels ;
      AV71Convenio_adicionalwwds_5_tfconveadiali = AV20TFConveAdiAli ;
      AV72Convenio_adicionalwwds_6_tfconveadiali_to = AV21TFConveAdiAli_To ;
      AV73Convenio_adicionalwwds_7_tfconveadiinfo = AV23TFConveAdiInfo ;
      AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels = AV24TFConveAdiInfo_Sels ;
      AV75Convenio_adicionalwwds_9_tfconveaditipo_sels = AV50TFConveAdiTipo_Sels ;
      AV76Convenio_adicionalwwds_10_tfconveadirelsec = AV51TFConveAdiRelSec ;
      AV77Convenio_adicionalwwds_11_tfconveadirelsec_to = AV52TFConveAdiRelSec_To ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A996ConveAdicod ,
                                           AV68Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                           A997ConveAdiDescri ,
                                           AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                           A1019ConveAdiInfo ,
                                           AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                           A1803ConveAdiTipo ,
                                           AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                           Integer.valueOf(AV68Convenio_adicionalwwds_2_tfconveadicod_sels.size()) ,
                                           AV67Convenio_adicionalwwds_1_tfconveadicod ,
                                           Integer.valueOf(AV70Convenio_adicionalwwds_4_tfconveadidescri_sels.size()) ,
                                           AV69Convenio_adicionalwwds_3_tfconveadidescri ,
                                           AV71Convenio_adicionalwwds_5_tfconveadiali ,
                                           AV72Convenio_adicionalwwds_6_tfconveadiali_to ,
                                           Integer.valueOf(AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels.size()) ,
                                           AV73Convenio_adicionalwwds_7_tfconveadiinfo ,
                                           Integer.valueOf(AV75Convenio_adicionalwwds_9_tfconveaditipo_sels.size()) ,
                                           Integer.valueOf(AV76Convenio_adicionalwwds_10_tfconveadirelsec) ,
                                           Integer.valueOf(AV77Convenio_adicionalwwds_11_tfconveadirelsec_to) ,
                                           A998ConveAdiAli ,
                                           Integer.valueOf(A1901ConveAdiRelSec) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV45CliCod) ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           Short.valueOf(AV46PaiCod) ,
                                           A1565CliConvenio ,
                                           AV48ConveCodigo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                           }
      });
      lV67Convenio_adicionalwwds_1_tfconveadicod = GXutil.padr( GXutil.rtrim( AV67Convenio_adicionalwwds_1_tfconveadicod), 20, "%") ;
      lV69Convenio_adicionalwwds_3_tfconveadidescri = GXutil.concat( GXutil.rtrim( AV69Convenio_adicionalwwds_3_tfconveadidescri), "%", "") ;
      lV73Convenio_adicionalwwds_7_tfconveadiinfo = GXutil.concat( GXutil.rtrim( AV73Convenio_adicionalwwds_7_tfconveadiinfo), "%", "") ;
      /* Using cursor P01FX4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV45CliCod), Short.valueOf(AV46PaiCod), AV48ConveCodigo, lV67Convenio_adicionalwwds_1_tfconveadicod, lV69Convenio_adicionalwwds_3_tfconveadidescri, AV71Convenio_adicionalwwds_5_tfconveadiali, AV72Convenio_adicionalwwds_6_tfconveadiali_to, lV73Convenio_adicionalwwds_7_tfconveadiinfo, Integer.valueOf(AV76Convenio_adicionalwwds_10_tfconveadirelsec), Integer.valueOf(AV77Convenio_adicionalwwds_11_tfconveadirelsec_to)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk1FX6 = false ;
         A3CliCod = P01FX4_A3CliCod[0] ;
         A1564CliPaiConve = P01FX4_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01FX4_A1565CliConvenio[0] ;
         A1019ConveAdiInfo = P01FX4_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = P01FX4_n1019ConveAdiInfo[0] ;
         A1901ConveAdiRelSec = P01FX4_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = P01FX4_n1901ConveAdiRelSec[0] ;
         A1803ConveAdiTipo = P01FX4_A1803ConveAdiTipo[0] ;
         A998ConveAdiAli = P01FX4_A998ConveAdiAli[0] ;
         A997ConveAdiDescri = P01FX4_A997ConveAdiDescri[0] ;
         A996ConveAdicod = P01FX4_A996ConveAdicod[0] ;
         AV31count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P01FX4_A1019ConveAdiInfo[0], A1019ConveAdiInfo) == 0 ) )
         {
            brk1FX6 = false ;
            A3CliCod = P01FX4_A3CliCod[0] ;
            A1564CliPaiConve = P01FX4_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01FX4_A1565CliConvenio[0] ;
            A996ConveAdicod = P01FX4_A996ConveAdicod[0] ;
            AV31count = (long)(AV31count+1) ;
            brk1FX6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1019ConveAdiInfo)==0) )
         {
            AV26Option = A1019ConveAdiInfo ;
            AV27Options.add(AV26Option, 0);
            AV30OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV31count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV27Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1FX6 )
         {
            brk1FX6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = convenio_adicionalwwgetfilterdata.this.AV40OptionsJson;
      this.aP4[0] = convenio_adicionalwwgetfilterdata.this.AV41OptionsDescJson;
      this.aP5[0] = convenio_adicionalwwgetfilterdata.this.AV42OptionIndexesJson;
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
      AV15TFConveAdicod = "" ;
      AV14TFConveAdicod_SelsJson = "" ;
      AV16TFConveAdicod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV18TFConveAdiDescri = "" ;
      AV17TFConveAdiDescri_SelsJson = "" ;
      AV19TFConveAdiDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFConveAdiAli = DecimalUtil.ZERO ;
      AV21TFConveAdiAli_To = DecimalUtil.ZERO ;
      AV23TFConveAdiInfo = "" ;
      AV22TFConveAdiInfo_SelsJson = "" ;
      AV24TFConveAdiInfo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49TFConveAdiTipo_SelsJson = "" ;
      AV50TFConveAdiTipo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV62MenuOpcCod = "" ;
      A996ConveAdicod = "" ;
      AV67Convenio_adicionalwwds_1_tfconveadicod = "" ;
      AV68Convenio_adicionalwwds_2_tfconveadicod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV69Convenio_adicionalwwds_3_tfconveadidescri = "" ;
      AV70Convenio_adicionalwwds_4_tfconveadidescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV71Convenio_adicionalwwds_5_tfconveadiali = DecimalUtil.ZERO ;
      AV72Convenio_adicionalwwds_6_tfconveadiali_to = DecimalUtil.ZERO ;
      AV73Convenio_adicionalwwds_7_tfconveadiinfo = "" ;
      AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV75Convenio_adicionalwwds_9_tfconveaditipo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV67Convenio_adicionalwwds_1_tfconveadicod = "" ;
      lV69Convenio_adicionalwwds_3_tfconveadidescri = "" ;
      lV73Convenio_adicionalwwds_7_tfconveadiinfo = "" ;
      A997ConveAdiDescri = "" ;
      A1019ConveAdiInfo = "" ;
      A1803ConveAdiTipo = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      AV48ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      P01FX2_A1565CliConvenio = new String[] {""} ;
      P01FX2_A1564CliPaiConve = new short[1] ;
      P01FX2_A3CliCod = new int[1] ;
      P01FX2_A996ConveAdicod = new String[] {""} ;
      P01FX2_A1901ConveAdiRelSec = new int[1] ;
      P01FX2_n1901ConveAdiRelSec = new boolean[] {false} ;
      P01FX2_A1803ConveAdiTipo = new String[] {""} ;
      P01FX2_A1019ConveAdiInfo = new String[] {""} ;
      P01FX2_n1019ConveAdiInfo = new boolean[] {false} ;
      P01FX2_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01FX2_A997ConveAdiDescri = new String[] {""} ;
      AV26Option = "" ;
      P01FX3_A3CliCod = new int[1] ;
      P01FX3_A1564CliPaiConve = new short[1] ;
      P01FX3_A1565CliConvenio = new String[] {""} ;
      P01FX3_A997ConveAdiDescri = new String[] {""} ;
      P01FX3_A1901ConveAdiRelSec = new int[1] ;
      P01FX3_n1901ConveAdiRelSec = new boolean[] {false} ;
      P01FX3_A1803ConveAdiTipo = new String[] {""} ;
      P01FX3_A1019ConveAdiInfo = new String[] {""} ;
      P01FX3_n1019ConveAdiInfo = new boolean[] {false} ;
      P01FX3_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01FX3_A996ConveAdicod = new String[] {""} ;
      P01FX4_A3CliCod = new int[1] ;
      P01FX4_A1564CliPaiConve = new short[1] ;
      P01FX4_A1565CliConvenio = new String[] {""} ;
      P01FX4_A1019ConveAdiInfo = new String[] {""} ;
      P01FX4_n1019ConveAdiInfo = new boolean[] {false} ;
      P01FX4_A1901ConveAdiRelSec = new int[1] ;
      P01FX4_n1901ConveAdiRelSec = new boolean[] {false} ;
      P01FX4_A1803ConveAdiTipo = new String[] {""} ;
      P01FX4_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01FX4_A997ConveAdiDescri = new String[] {""} ;
      P01FX4_A996ConveAdicod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01FX2_A1565CliConvenio, P01FX2_A1564CliPaiConve, P01FX2_A3CliCod, P01FX2_A996ConveAdicod, P01FX2_A1901ConveAdiRelSec, P01FX2_n1901ConveAdiRelSec, P01FX2_A1803ConveAdiTipo, P01FX2_A1019ConveAdiInfo, P01FX2_n1019ConveAdiInfo, P01FX2_A998ConveAdiAli,
            P01FX2_A997ConveAdiDescri
            }
            , new Object[] {
            P01FX3_A3CliCod, P01FX3_A1564CliPaiConve, P01FX3_A1565CliConvenio, P01FX3_A997ConveAdiDescri, P01FX3_A1901ConveAdiRelSec, P01FX3_n1901ConveAdiRelSec, P01FX3_A1803ConveAdiTipo, P01FX3_A1019ConveAdiInfo, P01FX3_n1019ConveAdiInfo, P01FX3_A998ConveAdiAli,
            P01FX3_A996ConveAdicod
            }
            , new Object[] {
            P01FX4_A3CliCod, P01FX4_A1564CliPaiConve, P01FX4_A1565CliConvenio, P01FX4_A1019ConveAdiInfo, P01FX4_n1019ConveAdiInfo, P01FX4_A1901ConveAdiRelSec, P01FX4_n1901ConveAdiRelSec, P01FX4_A1803ConveAdiTipo, P01FX4_A998ConveAdiAli, P01FX4_A997ConveAdiDescri,
            P01FX4_A996ConveAdicod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV44EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV46PaiCod ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV45CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV65GXV1 ;
   private int AV51TFConveAdiRelSec ;
   private int AV52TFConveAdiRelSec_To ;
   private int AV76Convenio_adicionalwwds_10_tfconveadirelsec ;
   private int AV77Convenio_adicionalwwds_11_tfconveadirelsec_to ;
   private int AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size ;
   private int AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size ;
   private int AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size ;
   private int AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size ;
   private int A1901ConveAdiRelSec ;
   private int A3CliCod ;
   private long AV31count ;
   private java.math.BigDecimal AV20TFConveAdiAli ;
   private java.math.BigDecimal AV21TFConveAdiAli_To ;
   private java.math.BigDecimal AV71Convenio_adicionalwwds_5_tfconveadiali ;
   private java.math.BigDecimal AV72Convenio_adicionalwwds_6_tfconveadiali_to ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private String AV15TFConveAdicod ;
   private String A996ConveAdicod ;
   private String AV67Convenio_adicionalwwds_1_tfconveadicod ;
   private String scmdbuf ;
   private String lV67Convenio_adicionalwwds_1_tfconveadicod ;
   private String A1803ConveAdiTipo ;
   private String AV48ConveCodigo ;
   private String A1565CliConvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1FX2 ;
   private boolean n1901ConveAdiRelSec ;
   private boolean n1019ConveAdiInfo ;
   private boolean brk1FX4 ;
   private boolean brk1FX6 ;
   private String AV40OptionsJson ;
   private String AV41OptionsDescJson ;
   private String AV42OptionIndexesJson ;
   private String AV14TFConveAdicod_SelsJson ;
   private String AV17TFConveAdiDescri_SelsJson ;
   private String AV22TFConveAdiInfo_SelsJson ;
   private String AV49TFConveAdiTipo_SelsJson ;
   private String A1019ConveAdiInfo ;
   private String AV37DDOName ;
   private String AV38SearchTxt ;
   private String AV39SearchTxtTo ;
   private String AV18TFConveAdiDescri ;
   private String AV23TFConveAdiInfo ;
   private String AV62MenuOpcCod ;
   private String AV69Convenio_adicionalwwds_3_tfconveadidescri ;
   private String AV73Convenio_adicionalwwds_7_tfconveadiinfo ;
   private String lV69Convenio_adicionalwwds_3_tfconveadidescri ;
   private String lV73Convenio_adicionalwwds_7_tfconveadiinfo ;
   private String A997ConveAdiDescri ;
   private String AV26Option ;
   private com.genexus.webpanels.WebSession AV32Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01FX2_A1565CliConvenio ;
   private short[] P01FX2_A1564CliPaiConve ;
   private int[] P01FX2_A3CliCod ;
   private String[] P01FX2_A996ConveAdicod ;
   private int[] P01FX2_A1901ConveAdiRelSec ;
   private boolean[] P01FX2_n1901ConveAdiRelSec ;
   private String[] P01FX2_A1803ConveAdiTipo ;
   private String[] P01FX2_A1019ConveAdiInfo ;
   private boolean[] P01FX2_n1019ConveAdiInfo ;
   private java.math.BigDecimal[] P01FX2_A998ConveAdiAli ;
   private String[] P01FX2_A997ConveAdiDescri ;
   private int[] P01FX3_A3CliCod ;
   private short[] P01FX3_A1564CliPaiConve ;
   private String[] P01FX3_A1565CliConvenio ;
   private String[] P01FX3_A997ConveAdiDescri ;
   private int[] P01FX3_A1901ConveAdiRelSec ;
   private boolean[] P01FX3_n1901ConveAdiRelSec ;
   private String[] P01FX3_A1803ConveAdiTipo ;
   private String[] P01FX3_A1019ConveAdiInfo ;
   private boolean[] P01FX3_n1019ConveAdiInfo ;
   private java.math.BigDecimal[] P01FX3_A998ConveAdiAli ;
   private String[] P01FX3_A996ConveAdicod ;
   private int[] P01FX4_A3CliCod ;
   private short[] P01FX4_A1564CliPaiConve ;
   private String[] P01FX4_A1565CliConvenio ;
   private String[] P01FX4_A1019ConveAdiInfo ;
   private boolean[] P01FX4_n1019ConveAdiInfo ;
   private int[] P01FX4_A1901ConveAdiRelSec ;
   private boolean[] P01FX4_n1901ConveAdiRelSec ;
   private String[] P01FX4_A1803ConveAdiTipo ;
   private java.math.BigDecimal[] P01FX4_A998ConveAdiAli ;
   private String[] P01FX4_A997ConveAdiDescri ;
   private String[] P01FX4_A996ConveAdicod ;
   private GXSimpleCollection<String> AV16TFConveAdicod_Sels ;
   private GXSimpleCollection<String> AV50TFConveAdiTipo_Sels ;
   private GXSimpleCollection<String> AV68Convenio_adicionalwwds_2_tfconveadicod_sels ;
   private GXSimpleCollection<String> AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ;
   private GXSimpleCollection<String> AV27Options ;
   private GXSimpleCollection<String> AV29OptionsDesc ;
   private GXSimpleCollection<String> AV30OptionIndexes ;
   private GXSimpleCollection<String> AV19TFConveAdiDescri_Sels ;
   private GXSimpleCollection<String> AV24TFConveAdiInfo_Sels ;
   private GXSimpleCollection<String> AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ;
   private GXSimpleCollection<String> AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV34GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV35GridStateFilterValue ;
}

final  class convenio_adicionalwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01FX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV68Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                          String A997ConveAdiDescri ,
                                          GXSimpleCollection<String> AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                          String A1019ConveAdiInfo ,
                                          GXSimpleCollection<String> AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                          String A1803ConveAdiTipo ,
                                          GXSimpleCollection<String> AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                          int AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size ,
                                          String AV67Convenio_adicionalwwds_1_tfconveadicod ,
                                          int AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size ,
                                          String AV69Convenio_adicionalwwds_3_tfconveadidescri ,
                                          java.math.BigDecimal AV71Convenio_adicionalwwds_5_tfconveadiali ,
                                          java.math.BigDecimal AV72Convenio_adicionalwwds_6_tfconveadiali_to ,
                                          int AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size ,
                                          String AV73Convenio_adicionalwwds_7_tfconveadiinfo ,
                                          int AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size ,
                                          int AV76Convenio_adicionalwwds_10_tfconveadirelsec ,
                                          int AV77Convenio_adicionalwwds_11_tfconveadirelsec_to ,
                                          java.math.BigDecimal A998ConveAdiAli ,
                                          int A1901ConveAdiRelSec ,
                                          int AV45CliCod ,
                                          short AV46PaiCod ,
                                          String AV48ConveCodigo ,
                                          int A3CliCod ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[10];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliConvenio, CliPaiConve, CliCod, ConveAdicod, ConveAdiRelSec, ConveAdiTipo, ConveAdiInfo, ConveAdiAli, ConveAdiDescri FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?))");
      if ( ( AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Convenio_adicionalwwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Convenio_adicionalwwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ( AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Convenio_adicionalwwds_3_tfconveadidescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Convenio_adicionalwwds_4_tfconveadidescri_sels, "ConveAdiDescri IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Convenio_adicionalwwds_5_tfconveadiali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli >= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Convenio_adicionalwwds_6_tfconveadiali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli <= ?)");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( ( AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Convenio_adicionalwwds_7_tfconveadiinfo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiInfo) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels, "ConveAdiInfo IN (", ")")+")");
      }
      if ( AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Convenio_adicionalwwds_9_tfconveaditipo_sels, "ConveAdiTipo IN (", ")")+")");
      }
      if ( ! (0==AV76Convenio_adicionalwwds_10_tfconveadirelsec) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec >= ?)");
      }
      else
      {
         GXv_int8[8] = (byte)(1) ;
      }
      if ( ! (0==AV77Convenio_adicionalwwds_11_tfconveadirelsec_to) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec <= ?)");
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

   protected Object[] conditional_P01FX3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV68Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                          String A997ConveAdiDescri ,
                                          GXSimpleCollection<String> AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                          String A1019ConveAdiInfo ,
                                          GXSimpleCollection<String> AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                          String A1803ConveAdiTipo ,
                                          GXSimpleCollection<String> AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                          int AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size ,
                                          String AV67Convenio_adicionalwwds_1_tfconveadicod ,
                                          int AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size ,
                                          String AV69Convenio_adicionalwwds_3_tfconveadidescri ,
                                          java.math.BigDecimal AV71Convenio_adicionalwwds_5_tfconveadiali ,
                                          java.math.BigDecimal AV72Convenio_adicionalwwds_6_tfconveadiali_to ,
                                          int AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size ,
                                          String AV73Convenio_adicionalwwds_7_tfconveadiinfo ,
                                          int AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size ,
                                          int AV76Convenio_adicionalwwds_10_tfconveadirelsec ,
                                          int AV77Convenio_adicionalwwds_11_tfconveadirelsec_to ,
                                          java.math.BigDecimal A998ConveAdiAli ,
                                          int A1901ConveAdiRelSec ,
                                          int A3CliCod ,
                                          int AV45CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV46PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV48ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[10];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdiDescri, ConveAdiRelSec, ConveAdiTipo, ConveAdiInfo, ConveAdiAli, ConveAdicod FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ( AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Convenio_adicionalwwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Convenio_adicionalwwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ( AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Convenio_adicionalwwds_3_tfconveadidescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Convenio_adicionalwwds_4_tfconveadidescri_sels, "ConveAdiDescri IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Convenio_adicionalwwds_5_tfconveadiali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Convenio_adicionalwwds_6_tfconveadiali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( ( AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Convenio_adicionalwwds_7_tfconveadiinfo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiInfo) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels, "ConveAdiInfo IN (", ")")+")");
      }
      if ( AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Convenio_adicionalwwds_9_tfconveaditipo_sels, "ConveAdiTipo IN (", ")")+")");
      }
      if ( ! (0==AV76Convenio_adicionalwwds_10_tfconveadirelsec) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec >= ?)");
      }
      else
      {
         GXv_int11[8] = (byte)(1) ;
      }
      if ( ! (0==AV77Convenio_adicionalwwds_11_tfconveadirelsec_to) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec <= ?)");
      }
      else
      {
         GXv_int11[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveAdiDescri" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P01FX4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A996ConveAdicod ,
                                          GXSimpleCollection<String> AV68Convenio_adicionalwwds_2_tfconveadicod_sels ,
                                          String A997ConveAdiDescri ,
                                          GXSimpleCollection<String> AV70Convenio_adicionalwwds_4_tfconveadidescri_sels ,
                                          String A1019ConveAdiInfo ,
                                          GXSimpleCollection<String> AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels ,
                                          String A1803ConveAdiTipo ,
                                          GXSimpleCollection<String> AV75Convenio_adicionalwwds_9_tfconveaditipo_sels ,
                                          int AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size ,
                                          String AV67Convenio_adicionalwwds_1_tfconveadicod ,
                                          int AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size ,
                                          String AV69Convenio_adicionalwwds_3_tfconveadidescri ,
                                          java.math.BigDecimal AV71Convenio_adicionalwwds_5_tfconveadiali ,
                                          java.math.BigDecimal AV72Convenio_adicionalwwds_6_tfconveadiali_to ,
                                          int AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size ,
                                          String AV73Convenio_adicionalwwds_7_tfconveadiinfo ,
                                          int AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size ,
                                          int AV76Convenio_adicionalwwds_10_tfconveadirelsec ,
                                          int AV77Convenio_adicionalwwds_11_tfconveadirelsec_to ,
                                          java.math.BigDecimal A998ConveAdiAli ,
                                          int A1901ConveAdiRelSec ,
                                          int A3CliCod ,
                                          int AV45CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV46PaiCod ,
                                          String A1565CliConvenio ,
                                          String AV48ConveCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[10];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdiInfo, ConveAdiRelSec, ConveAdiTipo, ConveAdiAli, ConveAdiDescri, ConveAdicod FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ( AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV67Convenio_adicionalwwds_1_tfconveadicod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdicod) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV68Convenio_adicionalwwds_2_tfconveadicod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV68Convenio_adicionalwwds_2_tfconveadicod_sels, "ConveAdicod IN (", ")")+")");
      }
      if ( ( AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV69Convenio_adicionalwwds_3_tfconveadidescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiDescri) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV70Convenio_adicionalwwds_4_tfconveadidescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV70Convenio_adicionalwwds_4_tfconveadidescri_sels, "ConveAdiDescri IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV71Convenio_adicionalwwds_5_tfconveadiali)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV72Convenio_adicionalwwds_6_tfconveadiali_to)==0) )
      {
         addWhere(sWhereString, "(ConveAdiAli <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      if ( ( AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV73Convenio_adicionalwwds_7_tfconveadiinfo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiInfo) like LOWER(?))");
      }
      else
      {
         GXv_int14[7] = (byte)(1) ;
      }
      if ( AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV74Convenio_adicionalwwds_8_tfconveadiinfo_sels, "ConveAdiInfo IN (", ")")+")");
      }
      if ( AV75Convenio_adicionalwwds_9_tfconveaditipo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV75Convenio_adicionalwwds_9_tfconveaditipo_sels, "ConveAdiTipo IN (", ")")+")");
      }
      if ( ! (0==AV76Convenio_adicionalwwds_10_tfconveadirelsec) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec >= ?)");
      }
      else
      {
         GXv_int14[8] = (byte)(1) ;
      }
      if ( ! (0==AV77Convenio_adicionalwwds_11_tfconveadirelsec_to) )
      {
         addWhere(sWhereString, "(ConveAdiRelSec <= ?)");
      }
      else
      {
         GXv_int14[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveAdiInfo" ;
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
                  return conditional_P01FX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).shortValue() , (String)dynConstraints[23] , ((Number) dynConstraints[24]).intValue() , ((Number) dynConstraints[25]).shortValue() , (String)dynConstraints[26] );
            case 1 :
                  return conditional_P01FX3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , (String)dynConstraints[25] , (String)dynConstraints[26] );
            case 2 :
                  return conditional_P01FX4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).intValue() , (java.math.BigDecimal)dynConstraints[19] , ((Number) dynConstraints[20]).intValue() , ((Number) dynConstraints[21]).intValue() , ((Number) dynConstraints[22]).intValue() , ((Number) dynConstraints[23]).shortValue() , ((Number) dynConstraints[24]).shortValue() , (String)dynConstraints[25] , (String)dynConstraints[26] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01FX3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01FX4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getVarchar(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getString(6, 20);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,4);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(6, 20);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,4);
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((String[]) buf[10])[0] = rslt.getString(9, 20);
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
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
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
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
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
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 4);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 4);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[17], 200);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               return;
      }
   }

}

