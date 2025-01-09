package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secuserwwgetfilterdata extends GXProcedure
{
   public secuserwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secuserwwgetfilterdata.class ), "" );
   }

   public secuserwwgetfilterdata( int remoteHandle ,
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
      secuserwwgetfilterdata.this.aP5 = new String[] {""};
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
      secuserwwgetfilterdata.this.AV19DDOName = aP0;
      secuserwwgetfilterdata.this.AV17SearchTxt = aP1;
      secuserwwgetfilterdata.this.AV18SearchTxtTo = aP2;
      secuserwwgetfilterdata.this.aP3 = aP3;
      secuserwwgetfilterdata.this.aP4 = aP4;
      secuserwwgetfilterdata.this.aP5 = aP5;
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
      secuserwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      secuserwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecUser", GXv_boolean6) ;
      secuserwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECUSERPERNAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSECUSERPERNAMEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_SECUSERPERLASTNAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSECUSERPERLASTNAMEOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV19DDOName), "DDO_ROLNOMBRE") == 0 )
         {
            /* Execute user subroutine: 'LOADROLNOMBREOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV23OptionsJson = AV22Options.toJSonString(false) ;
      AV26OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV28OptionIndexesJson = AV27OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV30Session.getValue("WWPBaseObjects.SecUserWWGridState"), "") == 0 )
      {
         AV32GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      else
      {
         AV32GridState.fromxml(AV30Session.getValue("WWPBaseObjects.SecUserWWGridState"), null, null);
      }
      AV45GXV1 = 1 ;
      while ( AV45GXV1 <= AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV33GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV32GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV45GXV1));
         if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSUACTIVO_SEL") == 0 )
         {
            AV38TFSecUsuActivo_Sel = (byte)(GXutil.lval( AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPERNAME") == 0 )
         {
            AV12TFSecUserPerName = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPERNAME_SEL") == 0 )
         {
            AV11TFSecUserPerName_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFSecUserPerName_Sels.fromJSonString(AV11TFSecUserPerName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPERLASTNAME") == 0 )
         {
            AV15TFSecUserPerLastName = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECUSERPERLASTNAME_SEL") == 0 )
         {
            AV14TFSecUserPerLastName_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFSecUserPerLastName_Sels.fromJSonString(AV14TFSecUserPerLastName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE") == 0 )
         {
            AV41TFRolNombre = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFROLNOMBRE_SEL") == 0 )
         {
            AV40TFRolNombre_SelsJson = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFRolNombre_Sels.fromJSonString(AV40TFRolNombre_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV33GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV45GXV1 = (int)(AV45GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECUSERPERNAMEOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecUserPerName = AV17SearchTxt ;
      AV13TFSecUserPerName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A359SecUserPerName ,
                                           AV13TFSecUserPerName_Sels ,
                                           A360SecUserPerLastName ,
                                           AV16TFSecUserPerLastName_Sels ,
                                           A1924RolNombre ,
                                           AV42TFRolNombre_Sels ,
                                           Byte.valueOf(AV38TFSecUsuActivo_Sel) ,
                                           Integer.valueOf(AV13TFSecUserPerName_Sels.size()) ,
                                           AV12TFSecUserPerName ,
                                           Integer.valueOf(AV16TFSecUserPerLastName_Sels.size()) ,
                                           AV15TFSecUserPerLastName ,
                                           Integer.valueOf(AV42TFRolNombre_Sels.size()) ,
                                           AV41TFRolNombre ,
                                           Boolean.valueOf(A364SecUsuActivo) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV12TFSecUserPerName = GXutil.concat( GXutil.rtrim( AV12TFSecUserPerName), "%", "") ;
      lV15TFSecUserPerLastName = GXutil.concat( GXutil.rtrim( AV15TFSecUserPerLastName), "%", "") ;
      lV41TFRolNombre = GXutil.concat( GXutil.rtrim( AV41TFRolNombre), "%", "") ;
      /* Using cursor P006T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV37CliCod), lV12TFSecUserPerName, lV15TFSecUserPerLastName, lV41TFRolNombre});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6T2 = false ;
         A1923RolId = P006T2_A1923RolId[0] ;
         n1923RolId = P006T2_n1923RolId[0] ;
         A359SecUserPerName = P006T2_A359SecUserPerName[0] ;
         A3CliCod = P006T2_A3CliCod[0] ;
         n3CliCod = P006T2_n3CliCod[0] ;
         A1924RolNombre = P006T2_A1924RolNombre[0] ;
         A360SecUserPerLastName = P006T2_A360SecUserPerLastName[0] ;
         A364SecUsuActivo = P006T2_A364SecUsuActivo[0] ;
         A67SecUserId = P006T2_A67SecUserId[0] ;
         A1924RolNombre = P006T2_A1924RolNombre[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P006T2_A359SecUserPerName[0], A359SecUserPerName) == 0 ) )
         {
            brk6T2 = false ;
            A67SecUserId = P006T2_A67SecUserId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6T2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A359SecUserPerName)==0) )
         {
            AV21Option = A359SecUserPerName ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6T2 )
         {
            brk6T2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECUSERPERLASTNAMEOPTIONS' Routine */
      returnInSub = false ;
      AV15TFSecUserPerLastName = AV17SearchTxt ;
      AV16TFSecUserPerLastName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A359SecUserPerName ,
                                           AV13TFSecUserPerName_Sels ,
                                           A360SecUserPerLastName ,
                                           AV16TFSecUserPerLastName_Sels ,
                                           A1924RolNombre ,
                                           AV42TFRolNombre_Sels ,
                                           Byte.valueOf(AV38TFSecUsuActivo_Sel) ,
                                           Integer.valueOf(AV13TFSecUserPerName_Sels.size()) ,
                                           AV12TFSecUserPerName ,
                                           Integer.valueOf(AV16TFSecUserPerLastName_Sels.size()) ,
                                           AV15TFSecUserPerLastName ,
                                           Integer.valueOf(AV42TFRolNombre_Sels.size()) ,
                                           AV41TFRolNombre ,
                                           Boolean.valueOf(A364SecUsuActivo) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV12TFSecUserPerName = GXutil.concat( GXutil.rtrim( AV12TFSecUserPerName), "%", "") ;
      lV15TFSecUserPerLastName = GXutil.concat( GXutil.rtrim( AV15TFSecUserPerLastName), "%", "") ;
      lV41TFRolNombre = GXutil.concat( GXutil.rtrim( AV41TFRolNombre), "%", "") ;
      /* Using cursor P006T3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV37CliCod), lV12TFSecUserPerName, lV15TFSecUserPerLastName, lV41TFRolNombre});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6T4 = false ;
         A1923RolId = P006T3_A1923RolId[0] ;
         n1923RolId = P006T3_n1923RolId[0] ;
         A360SecUserPerLastName = P006T3_A360SecUserPerLastName[0] ;
         A3CliCod = P006T3_A3CliCod[0] ;
         n3CliCod = P006T3_n3CliCod[0] ;
         A1924RolNombre = P006T3_A1924RolNombre[0] ;
         A359SecUserPerName = P006T3_A359SecUserPerName[0] ;
         A364SecUsuActivo = P006T3_A364SecUsuActivo[0] ;
         A67SecUserId = P006T3_A67SecUserId[0] ;
         A1924RolNombre = P006T3_A1924RolNombre[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P006T3_A360SecUserPerLastName[0], A360SecUserPerLastName) == 0 ) )
         {
            brk6T4 = false ;
            A67SecUserId = P006T3_A67SecUserId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6T4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A360SecUserPerLastName)==0) )
         {
            AV21Option = A360SecUserPerLastName ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6T4 )
         {
            brk6T4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADROLNOMBREOPTIONS' Routine */
      returnInSub = false ;
      AV41TFRolNombre = AV17SearchTxt ;
      AV42TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A359SecUserPerName ,
                                           AV13TFSecUserPerName_Sels ,
                                           A360SecUserPerLastName ,
                                           AV16TFSecUserPerLastName_Sels ,
                                           A1924RolNombre ,
                                           AV42TFRolNombre_Sels ,
                                           Byte.valueOf(AV38TFSecUsuActivo_Sel) ,
                                           Integer.valueOf(AV13TFSecUserPerName_Sels.size()) ,
                                           AV12TFSecUserPerName ,
                                           Integer.valueOf(AV16TFSecUserPerLastName_Sels.size()) ,
                                           AV15TFSecUserPerLastName ,
                                           Integer.valueOf(AV42TFRolNombre_Sels.size()) ,
                                           AV41TFRolNombre ,
                                           Boolean.valueOf(A364SecUsuActivo) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT
                                           }
      });
      lV12TFSecUserPerName = GXutil.concat( GXutil.rtrim( AV12TFSecUserPerName), "%", "") ;
      lV15TFSecUserPerLastName = GXutil.concat( GXutil.rtrim( AV15TFSecUserPerLastName), "%", "") ;
      lV41TFRolNombre = GXutil.concat( GXutil.rtrim( AV41TFRolNombre), "%", "") ;
      /* Using cursor P006T4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV37CliCod), lV12TFSecUserPerName, lV15TFSecUserPerLastName, lV41TFRolNombre});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6T6 = false ;
         A1923RolId = P006T4_A1923RolId[0] ;
         n1923RolId = P006T4_n1923RolId[0] ;
         A3CliCod = P006T4_A3CliCod[0] ;
         n3CliCod = P006T4_n3CliCod[0] ;
         A1924RolNombre = P006T4_A1924RolNombre[0] ;
         A360SecUserPerLastName = P006T4_A360SecUserPerLastName[0] ;
         A359SecUserPerName = P006T4_A359SecUserPerName[0] ;
         A364SecUsuActivo = P006T4_A364SecUsuActivo[0] ;
         A67SecUserId = P006T4_A67SecUserId[0] ;
         A1924RolNombre = P006T4_A1924RolNombre[0] ;
         AV29count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P006T4_A1924RolNombre[0], A1924RolNombre) == 0 ) )
         {
            brk6T6 = false ;
            A1923RolId = P006T4_A1923RolId[0] ;
            n1923RolId = P006T4_n1923RolId[0] ;
            A67SecUserId = P006T4_A67SecUserId[0] ;
            AV29count = (long)(AV29count+1) ;
            brk6T6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A1924RolNombre)==0) )
         {
            AV21Option = A1924RolNombre ;
            AV22Options.add(AV21Option, 0);
            AV27OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV29count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV22Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6T6 )
         {
            brk6T6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secuserwwgetfilterdata.this.AV23OptionsJson;
      this.aP4[0] = secuserwwgetfilterdata.this.AV26OptionsDescJson;
      this.aP5[0] = secuserwwgetfilterdata.this.AV28OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23OptionsJson = "" ;
      AV26OptionsDescJson = "" ;
      AV28OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV22Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV30Session = httpContext.getWebSession();
      AV32GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV33GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFSecUserPerName = "" ;
      AV11TFSecUserPerName_SelsJson = "" ;
      AV13TFSecUserPerName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFSecUserPerLastName = "" ;
      AV14TFSecUserPerLastName_SelsJson = "" ;
      AV16TFSecUserPerLastName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41TFRolNombre = "" ;
      AV40TFRolNombre_SelsJson = "" ;
      AV42TFRolNombre_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      scmdbuf = "" ;
      lV12TFSecUserPerName = "" ;
      lV15TFSecUserPerLastName = "" ;
      lV41TFRolNombre = "" ;
      A359SecUserPerName = "" ;
      A360SecUserPerLastName = "" ;
      A1924RolNombre = "" ;
      P006T2_A1923RolId = new byte[1] ;
      P006T2_n1923RolId = new boolean[] {false} ;
      P006T2_A359SecUserPerName = new String[] {""} ;
      P006T2_A3CliCod = new int[1] ;
      P006T2_n3CliCod = new boolean[] {false} ;
      P006T2_A1924RolNombre = new String[] {""} ;
      P006T2_A360SecUserPerLastName = new String[] {""} ;
      P006T2_A364SecUsuActivo = new boolean[] {false} ;
      P006T2_A67SecUserId = new short[1] ;
      AV21Option = "" ;
      P006T3_A1923RolId = new byte[1] ;
      P006T3_n1923RolId = new boolean[] {false} ;
      P006T3_A360SecUserPerLastName = new String[] {""} ;
      P006T3_A3CliCod = new int[1] ;
      P006T3_n3CliCod = new boolean[] {false} ;
      P006T3_A1924RolNombre = new String[] {""} ;
      P006T3_A359SecUserPerName = new String[] {""} ;
      P006T3_A364SecUsuActivo = new boolean[] {false} ;
      P006T3_A67SecUserId = new short[1] ;
      P006T4_A1923RolId = new byte[1] ;
      P006T4_n1923RolId = new boolean[] {false} ;
      P006T4_A3CliCod = new int[1] ;
      P006T4_n3CliCod = new boolean[] {false} ;
      P006T4_A1924RolNombre = new String[] {""} ;
      P006T4_A360SecUserPerLastName = new String[] {""} ;
      P006T4_A359SecUserPerName = new String[] {""} ;
      P006T4_A364SecUsuActivo = new boolean[] {false} ;
      P006T4_A67SecUserId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secuserwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006T2_A1923RolId, P006T2_n1923RolId, P006T2_A359SecUserPerName, P006T2_A3CliCod, P006T2_n3CliCod, P006T2_A1924RolNombre, P006T2_A360SecUserPerLastName, P006T2_A364SecUsuActivo, P006T2_A67SecUserId
            }
            , new Object[] {
            P006T3_A1923RolId, P006T3_n1923RolId, P006T3_A360SecUserPerLastName, P006T3_A3CliCod, P006T3_n3CliCod, P006T3_A1924RolNombre, P006T3_A359SecUserPerName, P006T3_A364SecUsuActivo, P006T3_A67SecUserId
            }
            , new Object[] {
            P006T4_A1923RolId, P006T4_n1923RolId, P006T4_A3CliCod, P006T4_n3CliCod, P006T4_A1924RolNombre, P006T4_A360SecUserPerLastName, P006T4_A359SecUserPerName, P006T4_A364SecUsuActivo, P006T4_A67SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV38TFSecUsuActivo_Sel ;
   private byte A1923RolId ;
   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A67SecUserId ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV45GXV1 ;
   private int AV13TFSecUserPerName_Sels_size ;
   private int AV16TFSecUserPerLastName_Sels_size ;
   private int AV42TFRolNombre_Sels_size ;
   private int A3CliCod ;
   private long AV29count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A364SecUsuActivo ;
   private boolean brk6T2 ;
   private boolean n1923RolId ;
   private boolean n3CliCod ;
   private boolean brk6T4 ;
   private boolean brk6T6 ;
   private String AV23OptionsJson ;
   private String AV26OptionsDescJson ;
   private String AV28OptionIndexesJson ;
   private String AV11TFSecUserPerName_SelsJson ;
   private String AV14TFSecUserPerLastName_SelsJson ;
   private String AV40TFRolNombre_SelsJson ;
   private String AV19DDOName ;
   private String AV17SearchTxt ;
   private String AV18SearchTxtTo ;
   private String AV12TFSecUserPerName ;
   private String AV15TFSecUserPerLastName ;
   private String AV41TFRolNombre ;
   private String AV39MenuOpcCod ;
   private String lV12TFSecUserPerName ;
   private String lV15TFSecUserPerLastName ;
   private String lV41TFRolNombre ;
   private String A359SecUserPerName ;
   private String A360SecUserPerLastName ;
   private String A1924RolNombre ;
   private String AV21Option ;
   private com.genexus.webpanels.WebSession AV30Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P006T2_A1923RolId ;
   private boolean[] P006T2_n1923RolId ;
   private String[] P006T2_A359SecUserPerName ;
   private int[] P006T2_A3CliCod ;
   private boolean[] P006T2_n3CliCod ;
   private String[] P006T2_A1924RolNombre ;
   private String[] P006T2_A360SecUserPerLastName ;
   private boolean[] P006T2_A364SecUsuActivo ;
   private short[] P006T2_A67SecUserId ;
   private byte[] P006T3_A1923RolId ;
   private boolean[] P006T3_n1923RolId ;
   private String[] P006T3_A360SecUserPerLastName ;
   private int[] P006T3_A3CliCod ;
   private boolean[] P006T3_n3CliCod ;
   private String[] P006T3_A1924RolNombre ;
   private String[] P006T3_A359SecUserPerName ;
   private boolean[] P006T3_A364SecUsuActivo ;
   private short[] P006T3_A67SecUserId ;
   private byte[] P006T4_A1923RolId ;
   private boolean[] P006T4_n1923RolId ;
   private int[] P006T4_A3CliCod ;
   private boolean[] P006T4_n3CliCod ;
   private String[] P006T4_A1924RolNombre ;
   private String[] P006T4_A360SecUserPerLastName ;
   private String[] P006T4_A359SecUserPerName ;
   private boolean[] P006T4_A364SecUsuActivo ;
   private short[] P006T4_A67SecUserId ;
   private GXSimpleCollection<String> AV22Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV27OptionIndexes ;
   private GXSimpleCollection<String> AV13TFSecUserPerName_Sels ;
   private GXSimpleCollection<String> AV16TFSecUserPerLastName_Sels ;
   private GXSimpleCollection<String> AV42TFRolNombre_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV32GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV33GridStateFilterValue ;
}

final  class secuserwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A359SecUserPerName ,
                                          GXSimpleCollection<String> AV13TFSecUserPerName_Sels ,
                                          String A360SecUserPerLastName ,
                                          GXSimpleCollection<String> AV16TFSecUserPerLastName_Sels ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV42TFRolNombre_Sels ,
                                          byte AV38TFSecUsuActivo_Sel ,
                                          int AV13TFSecUserPerName_Sels_size ,
                                          String AV12TFSecUserPerName ,
                                          int AV16TFSecUserPerLastName_Sels_size ,
                                          String AV15TFSecUserPerLastName ,
                                          int AV42TFRolNombre_Sels_size ,
                                          String AV41TFRolNombre ,
                                          boolean A364SecUsuActivo ,
                                          int A3CliCod ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.SecUserPerName, T1.CliCod, T2.RolNombre, T1.SecUserPerLastName, T1.SecUsuActivo, T1.SecUserId FROM (SecUser T1 LEFT JOIN RolUsuario T2 ON T2.RolId" ;
      scmdbuf += " = T1.RolId)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( AV38TFSecUsuActivo_Sel == 1 )
      {
         addWhere(sWhereString, "(T1.SecUsuActivo = TRUE)");
      }
      if ( AV38TFSecUsuActivo_Sel == 2 )
      {
         addWhere(sWhereString, "(T1.SecUsuActivo = FALSE)");
      }
      if ( ( AV13TFSecUserPerName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFSecUserPerName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecUserPerName) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV13TFSecUserPerName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFSecUserPerName_Sels, "T1.SecUserPerName IN (", ")")+")");
      }
      if ( ( AV16TFSecUserPerLastName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFSecUserPerLastName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecUserPerLastName) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV16TFSecUserPerLastName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFSecUserPerLastName_Sels, "T1.SecUserPerLastName IN (", ")")+")");
      }
      if ( ( AV42TFRolNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV41TFRolNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV42TFRolNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV42TFRolNombre_Sels, "T2.RolNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecUserPerName" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A359SecUserPerName ,
                                          GXSimpleCollection<String> AV13TFSecUserPerName_Sels ,
                                          String A360SecUserPerLastName ,
                                          GXSimpleCollection<String> AV16TFSecUserPerLastName_Sels ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV42TFRolNombre_Sels ,
                                          byte AV38TFSecUsuActivo_Sel ,
                                          int AV13TFSecUserPerName_Sels_size ,
                                          String AV12TFSecUserPerName ,
                                          int AV16TFSecUserPerLastName_Sels_size ,
                                          String AV15TFSecUserPerLastName ,
                                          int AV42TFRolNombre_Sels_size ,
                                          String AV41TFRolNombre ,
                                          boolean A364SecUsuActivo ,
                                          int A3CliCod ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.SecUserPerLastName, T1.CliCod, T2.RolNombre, T1.SecUserPerName, T1.SecUsuActivo, T1.SecUserId FROM (SecUser T1 LEFT JOIN RolUsuario T2 ON T2.RolId" ;
      scmdbuf += " = T1.RolId)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( AV38TFSecUsuActivo_Sel == 1 )
      {
         addWhere(sWhereString, "(T1.SecUsuActivo = TRUE)");
      }
      if ( AV38TFSecUsuActivo_Sel == 2 )
      {
         addWhere(sWhereString, "(T1.SecUsuActivo = FALSE)");
      }
      if ( ( AV13TFSecUserPerName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFSecUserPerName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecUserPerName) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV13TFSecUserPerName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFSecUserPerName_Sels, "T1.SecUserPerName IN (", ")")+")");
      }
      if ( ( AV16TFSecUserPerLastName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFSecUserPerLastName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecUserPerLastName) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV16TFSecUserPerLastName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFSecUserPerLastName_Sels, "T1.SecUserPerLastName IN (", ")")+")");
      }
      if ( ( AV42TFRolNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV41TFRolNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV42TFRolNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV42TFRolNombre_Sels, "T2.RolNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.SecUserPerLastName" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006T4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A359SecUserPerName ,
                                          GXSimpleCollection<String> AV13TFSecUserPerName_Sels ,
                                          String A360SecUserPerLastName ,
                                          GXSimpleCollection<String> AV16TFSecUserPerLastName_Sels ,
                                          String A1924RolNombre ,
                                          GXSimpleCollection<String> AV42TFRolNombre_Sels ,
                                          byte AV38TFSecUsuActivo_Sel ,
                                          int AV13TFSecUserPerName_Sels_size ,
                                          String AV12TFSecUserPerName ,
                                          int AV16TFSecUserPerLastName_Sels_size ,
                                          String AV15TFSecUserPerLastName ,
                                          int AV42TFRolNombre_Sels_size ,
                                          String AV41TFRolNombre ,
                                          boolean A364SecUsuActivo ,
                                          int A3CliCod ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT T1.RolId, T1.CliCod, T2.RolNombre, T1.SecUserPerLastName, T1.SecUserPerName, T1.SecUsuActivo, T1.SecUserId FROM (SecUser T1 LEFT JOIN RolUsuario T2 ON T2.RolId" ;
      scmdbuf += " = T1.RolId)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( AV38TFSecUsuActivo_Sel == 1 )
      {
         addWhere(sWhereString, "(T1.SecUsuActivo = TRUE)");
      }
      if ( AV38TFSecUsuActivo_Sel == 2 )
      {
         addWhere(sWhereString, "(T1.SecUsuActivo = FALSE)");
      }
      if ( ( AV13TFSecUserPerName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV12TFSecUserPerName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecUserPerName) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV13TFSecUserPerName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV13TFSecUserPerName_Sels, "T1.SecUserPerName IN (", ")")+")");
      }
      if ( ( AV16TFSecUserPerLastName_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV15TFSecUserPerLastName)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.SecUserPerLastName) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV16TFSecUserPerLastName_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV16TFSecUserPerLastName_Sels, "T1.SecUserPerLastName IN (", ")")+")");
      }
      if ( ( AV42TFRolNombre_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV41TFRolNombre)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.RolNombre) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV42TFRolNombre_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV42TFRolNombre_Sels, "T2.RolNombre IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T2.RolNombre" ;
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
                  return conditional_P006T2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 1 :
                  return conditional_P006T3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 2 :
                  return conditional_P006T4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006T4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getVarchar(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getVarchar(3);
               ((String[]) buf[5])[0] = rslt.getVarchar(4);
               ((String[]) buf[6])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
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
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
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
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 30);
               }
               return;
      }
   }

}

