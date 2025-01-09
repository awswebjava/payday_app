package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class provinciawwgetfilterdata extends GXProcedure
{
   public provinciawwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( provinciawwgetfilterdata.class ), "" );
   }

   public provinciawwgetfilterdata( int remoteHandle ,
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
      provinciawwgetfilterdata.this.aP5 = new String[] {""};
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
      provinciawwgetfilterdata.this.AV28DDOName = aP0;
      provinciawwgetfilterdata.this.AV29SearchTxt = aP1;
      provinciawwgetfilterdata.this.AV30SearchTxtTo = aP2;
      provinciawwgetfilterdata.this.aP3 = aP3;
      provinciawwgetfilterdata.this.aP4 = aP4;
      provinciawwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV35EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      provinciawwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV35EmpCod = GXt_int1 ;
      GXt_int3 = AV36CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      provinciawwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV36CliCod = GXt_int3 ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWProvincia", GXv_boolean6) ;
      provinciawwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV28DDOName), "DDO_PROVNOM") == 0 )
         {
            /* Execute user subroutine: 'LOADPROVNOMOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV31OptionsJson = AV18Options.toJSonString(false) ;
      AV32OptionsDescJson = AV20OptionsDesc.toJSonString(false) ;
      AV33OptionIndexesJson = AV21OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV23Session.getValue("ProvinciaWWGridState"), "") == 0 )
      {
         AV25GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ProvinciaWWGridState"), null, null);
      }
      else
      {
         AV25GridState.fromxml(AV23Session.getValue("ProvinciaWWGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV26GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV25GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVCOD") == 0 )
         {
            AV11TFProvCod = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFProvCod_To = (short)(GXutil.lval( AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVNOM") == 0 )
         {
            AV14TFProvNom = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPROVNOM_SEL") == 0 )
         {
            AV13TFProvNom_SelsJson = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFProvNom_Sels.fromJSonString(AV13TFProvNom_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV38MenuOpcCod = AV26GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPROVNOMOPTIONS' Routine */
      returnInSub = false ;
      AV14TFProvNom = AV29SearchTxt ;
      AV15TFProvNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Provinciawwds_1_tfprovcod = AV11TFProvCod ;
      AV44Provinciawwds_2_tfprovcod_to = AV12TFProvCod_To ;
      AV45Provinciawwds_3_tfprovnom = AV14TFProvNom ;
      AV46Provinciawwds_4_tfprovnom_sels = AV15TFProvNom_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A322ProvNom ,
                                           AV46Provinciawwds_4_tfprovnom_sels ,
                                           Short.valueOf(AV43Provinciawwds_1_tfprovcod) ,
                                           Short.valueOf(AV44Provinciawwds_2_tfprovcod_to) ,
                                           Integer.valueOf(AV46Provinciawwds_4_tfprovnom_sels.size()) ,
                                           AV45Provinciawwds_3_tfprovnom ,
                                           Short.valueOf(AV37PaiCod) ,
                                           Short.valueOf(A47ProvCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV45Provinciawwds_3_tfprovnom = GXutil.concat( GXutil.rtrim( AV45Provinciawwds_3_tfprovnom), "%", "") ;
      /* Using cursor P01GR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV43Provinciawwds_1_tfprovcod), Short.valueOf(AV44Provinciawwds_2_tfprovcod_to), lV45Provinciawwds_3_tfprovnom, Short.valueOf(AV37PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1GR2 = false ;
         A322ProvNom = P01GR2_A322ProvNom[0] ;
         A46PaiCod = P01GR2_A46PaiCod[0] ;
         A47ProvCod = P01GR2_A47ProvCod[0] ;
         AV22count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01GR2_A322ProvNom[0], A322ProvNom) == 0 ) )
         {
            brk1GR2 = false ;
            A46PaiCod = P01GR2_A46PaiCod[0] ;
            A47ProvCod = P01GR2_A47ProvCod[0] ;
            AV22count = (long)(AV22count+1) ;
            brk1GR2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A322ProvNom)==0) )
         {
            AV17Option = A322ProvNom ;
            AV18Options.add(AV17Option, 0);
            AV21OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV22count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV18Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1GR2 )
         {
            brk1GR2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = provinciawwgetfilterdata.this.AV31OptionsJson;
      this.aP4[0] = provinciawwgetfilterdata.this.AV32OptionsDescJson;
      this.aP5[0] = provinciawwgetfilterdata.this.AV33OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV31OptionsJson = "" ;
      AV32OptionsDescJson = "" ;
      AV33OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV18Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV23Session = httpContext.getWebSession();
      AV25GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV26GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV14TFProvNom = "" ;
      AV13TFProvNom_SelsJson = "" ;
      AV15TFProvNom_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38MenuOpcCod = "" ;
      A322ProvNom = "" ;
      AV45Provinciawwds_3_tfprovnom = "" ;
      AV46Provinciawwds_4_tfprovnom_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV45Provinciawwds_3_tfprovnom = "" ;
      P01GR2_A322ProvNom = new String[] {""} ;
      P01GR2_A46PaiCod = new short[1] ;
      P01GR2_A47ProvCod = new short[1] ;
      AV17Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.provinciawwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01GR2_A322ProvNom, P01GR2_A46PaiCod, P01GR2_A47ProvCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV35EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFProvCod ;
   private short AV12TFProvCod_To ;
   private short AV43Provinciawwds_1_tfprovcod ;
   private short AV44Provinciawwds_2_tfprovcod_to ;
   private short AV37PaiCod ;
   private short A47ProvCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV36CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV41GXV1 ;
   private int AV46Provinciawwds_4_tfprovnom_sels_size ;
   private long AV22count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1GR2 ;
   private String AV31OptionsJson ;
   private String AV32OptionsDescJson ;
   private String AV33OptionIndexesJson ;
   private String AV13TFProvNom_SelsJson ;
   private String AV28DDOName ;
   private String AV29SearchTxt ;
   private String AV30SearchTxtTo ;
   private String AV14TFProvNom ;
   private String AV38MenuOpcCod ;
   private String A322ProvNom ;
   private String AV45Provinciawwds_3_tfprovnom ;
   private String lV45Provinciawwds_3_tfprovnom ;
   private String AV17Option ;
   private com.genexus.webpanels.WebSession AV23Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GR2_A322ProvNom ;
   private short[] P01GR2_A46PaiCod ;
   private short[] P01GR2_A47ProvCod ;
   private GXSimpleCollection<String> AV18Options ;
   private GXSimpleCollection<String> AV20OptionsDesc ;
   private GXSimpleCollection<String> AV21OptionIndexes ;
   private GXSimpleCollection<String> AV15TFProvNom_Sels ;
   private GXSimpleCollection<String> AV46Provinciawwds_4_tfprovnom_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV25GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV26GridStateFilterValue ;
}

final  class provinciawwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01GR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A322ProvNom ,
                                          GXSimpleCollection<String> AV46Provinciawwds_4_tfprovnom_sels ,
                                          short AV43Provinciawwds_1_tfprovcod ,
                                          short AV44Provinciawwds_2_tfprovcod_to ,
                                          int AV46Provinciawwds_4_tfprovnom_sels_size ,
                                          String AV45Provinciawwds_3_tfprovnom ,
                                          short AV37PaiCod ,
                                          short A47ProvCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT ProvNom, PaiCod, ProvCod FROM Provincia" ;
      if ( ! (0==AV43Provinciawwds_1_tfprovcod) )
      {
         addWhere(sWhereString, "(ProvCod >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV44Provinciawwds_2_tfprovcod_to) )
      {
         addWhere(sWhereString, "(ProvCod <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV46Provinciawwds_4_tfprovnom_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Provinciawwds_3_tfprovnom)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ProvNom) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV46Provinciawwds_4_tfprovnom_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Provinciawwds_4_tfprovnom_sels, "ProvNom IN (", ")")+")");
      }
      if ( ! (0==AV37PaiCod) )
      {
         addWhere(sWhereString, "(PaiCod = ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ProvNom" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P01GR2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               return;
      }
   }

}

