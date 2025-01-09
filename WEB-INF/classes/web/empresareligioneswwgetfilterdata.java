package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresareligioneswwgetfilterdata extends GXProcedure
{
   public empresareligioneswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresareligioneswwgetfilterdata.class ), "" );
   }

   public empresareligioneswwgetfilterdata( int remoteHandle ,
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
      empresareligioneswwgetfilterdata.this.aP5 = new String[] {""};
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
      empresareligioneswwgetfilterdata.this.AV30DDOName = aP0;
      empresareligioneswwgetfilterdata.this.AV31SearchTxt = aP1;
      empresareligioneswwgetfilterdata.this.AV32SearchTxtTo = aP2;
      empresareligioneswwgetfilterdata.this.aP3 = aP3;
      empresareligioneswwgetfilterdata.this.aP4 = aP4;
      empresareligioneswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV37EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      empresareligioneswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV37EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      empresareligioneswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresaReligiones", GXv_boolean6) ;
      empresareligioneswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_EMPRELIGION") == 0 )
         {
            /* Execute user subroutine: 'LOADEMPRELIGIONOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV33OptionsJson = AV20Options.toJSonString(false) ;
      AV34OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV35OptionIndexesJson = AV23OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV25Session.getValue("EmpresaReligionesWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "EmpresaReligionesWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("EmpresaReligionesWWGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPRELIGION") == 0 )
         {
            AV16TFEmpReligion = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPRELIGION_SEL") == 0 )
         {
            AV15TFEmpReligion_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFEmpReligion_Sels.fromJSonString(AV15TFEmpReligion_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADEMPRELIGIONOPTIONS' Routine */
      returnInSub = false ;
      AV16TFEmpReligion = AV31SearchTxt ;
      AV17TFEmpReligion_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV44Empresareligioneswwds_1_tfempreligion = AV16TFEmpReligion ;
      AV45Empresareligioneswwds_2_tfempreligion_sels = AV17TFEmpReligion_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1237EmpReligion ,
                                           AV45Empresareligioneswwds_2_tfempreligion_sels ,
                                           Integer.valueOf(AV45Empresareligioneswwds_2_tfempreligion_sels.size()) ,
                                           AV44Empresareligioneswwds_1_tfempreligion ,
                                           A1283ReligNombre ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Short.valueOf(AV37EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV44Empresareligioneswwds_1_tfempreligion = GXutil.concat( GXutil.rtrim( AV44Empresareligioneswwds_1_tfempreligion), "%", "") ;
      /* Using cursor P01DP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), Short.valueOf(AV37EmpCod), lV44Empresareligioneswwds_1_tfempreligion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1DP2 = false ;
         A1229ReligId = P01DP2_A1229ReligId[0] ;
         A1EmpCod = P01DP2_A1EmpCod[0] ;
         A3CliCod = P01DP2_A3CliCod[0] ;
         A1237EmpReligion = P01DP2_A1237EmpReligion[0] ;
         A1283ReligNombre = P01DP2_A1283ReligNombre[0] ;
         A1283ReligNombre = P01DP2_A1283ReligNombre[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01DP2_A3CliCod[0] == A3CliCod ) && ( P01DP2_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P01DP2_A1237EmpReligion[0], A1237EmpReligion) == 0 ) )
         {
            brk1DP2 = false ;
            AV24count = (long)(AV24count+1) ;
            brk1DP2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1283ReligNombre)==0) )
         {
            AV19Option = A1237EmpReligion ;
            AV21OptionDesc = A1283ReligNombre ;
            AV18InsertIndex = 1 ;
            while ( ( AV18InsertIndex <= AV20Options.size() ) && ( GXutil.strcmp((String)AV22OptionsDesc.elementAt(-1+AV18InsertIndex), AV21OptionDesc) < 0 ) )
            {
               AV18InsertIndex = (int)(AV18InsertIndex+1) ;
            }
            AV20Options.add(AV19Option, AV18InsertIndex);
            AV22OptionsDesc.add(AV21OptionDesc, AV18InsertIndex);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), AV18InsertIndex);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1DP2 )
         {
            brk1DP2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = empresareligioneswwgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = empresareligioneswwgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = empresareligioneswwgetfilterdata.this.AV35OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV33OptionsJson = "" ;
      AV34OptionsDescJson = "" ;
      AV35OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV16TFEmpReligion = "" ;
      AV15TFEmpReligion_SelsJson = "" ;
      AV17TFEmpReligion_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      A1283ReligNombre = "" ;
      A1237EmpReligion = "" ;
      AV44Empresareligioneswwds_1_tfempreligion = "" ;
      AV45Empresareligioneswwds_2_tfempreligion_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV44Empresareligioneswwds_1_tfempreligion = "" ;
      P01DP2_A1229ReligId = new String[] {""} ;
      P01DP2_A1EmpCod = new short[1] ;
      P01DP2_A3CliCod = new int[1] ;
      P01DP2_A1237EmpReligion = new String[] {""} ;
      P01DP2_A1283ReligNombre = new String[] {""} ;
      A1229ReligId = "" ;
      AV19Option = "" ;
      AV21OptionDesc = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresareligioneswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01DP2_A1229ReligId, P01DP2_A1EmpCod, P01DP2_A3CliCod, P01DP2_A1237EmpReligion, P01DP2_A1283ReligNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV42GXV1 ;
   private int AV45Empresareligioneswwds_2_tfempreligion_sels_size ;
   private int A3CliCod ;
   private int AV18InsertIndex ;
   private long AV24count ;
   private String A1237EmpReligion ;
   private String scmdbuf ;
   private String A1229ReligId ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk1DP2 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV15TFEmpReligion_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV16TFEmpReligion ;
   private String AV39MenuOpcCod ;
   private String A1283ReligNombre ;
   private String AV44Empresareligioneswwds_1_tfempreligion ;
   private String lV44Empresareligioneswwds_1_tfempreligion ;
   private String AV19Option ;
   private String AV21OptionDesc ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01DP2_A1229ReligId ;
   private short[] P01DP2_A1EmpCod ;
   private int[] P01DP2_A3CliCod ;
   private String[] P01DP2_A1237EmpReligion ;
   private String[] P01DP2_A1283ReligNombre ;
   private GXSimpleCollection<String> AV17TFEmpReligion_Sels ;
   private GXSimpleCollection<String> AV45Empresareligioneswwds_2_tfempreligion_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class empresareligioneswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01DP2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1237EmpReligion ,
                                          GXSimpleCollection<String> AV45Empresareligioneswwds_2_tfempreligion_sels ,
                                          int AV45Empresareligioneswwds_2_tfempreligion_sels_size ,
                                          String AV44Empresareligioneswwds_1_tfempreligion ,
                                          String A1283ReligNombre ,
                                          int AV38CliCod ,
                                          short AV37EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T2.ReligId, T1.EmpCod, T1.CliCod, T1.EmpReligion, T2.ReligNombre FROM (Empresanolaborables_religion T1 INNER JOIN Religion T2 ON T2.ReligId = T1.EmpReligion)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      if ( ( AV45Empresareligioneswwds_2_tfempreligion_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV44Empresareligioneswwds_1_tfempreligion)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ReligNombre) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV45Empresareligioneswwds_2_tfempreligion_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Empresareligioneswwds_2_tfempreligion_sels, "T1.EmpReligion IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.EmpReligion" ;
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
                  return conditional_P01DP2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01DP2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 30);
               }
               return;
      }
   }

}

