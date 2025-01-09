package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class situacionrevistaafipwwgetfilterdata extends GXProcedure
{
   public situacionrevistaafipwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( situacionrevistaafipwwgetfilterdata.class ), "" );
   }

   public situacionrevistaafipwwgetfilterdata( int remoteHandle ,
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
      situacionrevistaafipwwgetfilterdata.this.aP5 = new String[] {""};
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
      situacionrevistaafipwwgetfilterdata.this.AV29DDOName = aP0;
      situacionrevistaafipwwgetfilterdata.this.AV30SearchTxt = aP1;
      situacionrevistaafipwwgetfilterdata.this.AV31SearchTxtTo = aP2;
      situacionrevistaafipwwgetfilterdata.this.aP3 = aP3;
      situacionrevistaafipwwgetfilterdata.this.aP4 = aP4;
      situacionrevistaafipwwgetfilterdata.this.aP5 = aP5;
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
      situacionrevistaafipwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      situacionrevistaafipwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSituacionRevistaAFIP", GXv_boolean6) ;
      situacionrevistaafipwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_SITREVDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADSITREVDESCRIPOPTIONS' */
            S121 ();
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
      if ( GXutil.strcmp(AV24Session.getValue("SituacionRevistaAFIPWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SituacionRevistaAFIPWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("SituacionRevistaAFIPWWGridState"), null, null);
      }
      AV41GXV1 = 1 ;
      while ( AV41GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV41GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITREVCODIGO") == 0 )
         {
            AV11TFSitRevCodigo = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFSitRevCodigo_To = (short)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITREVDESCRIP") == 0 )
         {
            AV14TFSitRevDescrip = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITREVDESCRIP_SEL") == 0 )
         {
            AV13TFSitRevDescrip_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV15TFSitRevDescrip_Sels.fromJSonString(AV13TFSitRevDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSITREVESBAJA_SEL") == 0 )
         {
            AV16TFSitRevEsBaja_Sel = (byte)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV38MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV41GXV1 = (int)(AV41GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSITREVDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV14TFSitRevDescrip = AV30SearchTxt ;
      AV15TFSitRevDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV43Situacionrevistaafipwwds_1_tfsitrevcodigo = AV11TFSitRevCodigo ;
      AV44Situacionrevistaafipwwds_2_tfsitrevcodigo_to = AV12TFSitRevCodigo_To ;
      AV45Situacionrevistaafipwwds_3_tfsitrevdescrip = AV14TFSitRevDescrip ;
      AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels = AV15TFSitRevDescrip_Sels ;
      AV47Situacionrevistaafipwwds_5_tfsitrevesbaja_sel = AV16TFSitRevEsBaja_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1596SitRevDescrip ,
                                           AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels ,
                                           Short.valueOf(AV43Situacionrevistaafipwwds_1_tfsitrevcodigo) ,
                                           Short.valueOf(AV44Situacionrevistaafipwwds_2_tfsitrevcodigo_to) ,
                                           Integer.valueOf(AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels.size()) ,
                                           AV45Situacionrevistaafipwwds_3_tfsitrevdescrip ,
                                           Byte.valueOf(AV47Situacionrevistaafipwwds_5_tfsitrevesbaja_sel) ,
                                           Short.valueOf(A1595SitRevCodigo) ,
                                           Boolean.valueOf(A1597SitRevEsBaja) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV45Situacionrevistaafipwwds_3_tfsitrevdescrip = GXutil.concat( GXutil.rtrim( AV45Situacionrevistaafipwwds_3_tfsitrevdescrip), "%", "") ;
      /* Using cursor P01HL2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV43Situacionrevistaafipwwds_1_tfsitrevcodigo), Short.valueOf(AV44Situacionrevistaafipwwds_2_tfsitrevcodigo_to), lV45Situacionrevistaafipwwds_3_tfsitrevdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1HL2 = false ;
         A1596SitRevDescrip = P01HL2_A1596SitRevDescrip[0] ;
         A1597SitRevEsBaja = P01HL2_A1597SitRevEsBaja[0] ;
         A1595SitRevCodigo = P01HL2_A1595SitRevCodigo[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01HL2_A1596SitRevDescrip[0], A1596SitRevDescrip) == 0 ) )
         {
            brk1HL2 = false ;
            A1595SitRevCodigo = P01HL2_A1595SitRevCodigo[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1HL2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1596SitRevDescrip)==0) )
         {
            AV18Option = A1596SitRevDescrip ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1HL2 )
         {
            brk1HL2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = situacionrevistaafipwwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = situacionrevistaafipwwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = situacionrevistaafipwwgetfilterdata.this.AV34OptionIndexesJson;
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
      AV14TFSitRevDescrip = "" ;
      AV13TFSitRevDescrip_SelsJson = "" ;
      AV15TFSitRevDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38MenuOpcCod = "" ;
      A1596SitRevDescrip = "" ;
      AV45Situacionrevistaafipwwds_3_tfsitrevdescrip = "" ;
      AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV45Situacionrevistaafipwwds_3_tfsitrevdescrip = "" ;
      P01HL2_A1596SitRevDescrip = new String[] {""} ;
      P01HL2_A1597SitRevEsBaja = new boolean[] {false} ;
      P01HL2_A1595SitRevCodigo = new short[1] ;
      AV18Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.situacionrevistaafipwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01HL2_A1596SitRevDescrip, P01HL2_A1597SitRevEsBaja, P01HL2_A1595SitRevCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16TFSitRevEsBaja_Sel ;
   private byte AV47Situacionrevistaafipwwds_5_tfsitrevesbaja_sel ;
   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV11TFSitRevCodigo ;
   private short AV12TFSitRevCodigo_To ;
   private short AV43Situacionrevistaafipwwds_1_tfsitrevcodigo ;
   private short AV44Situacionrevistaafipwwds_2_tfsitrevcodigo_to ;
   private short A1595SitRevCodigo ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV41GXV1 ;
   private int AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels_size ;
   private long AV23count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1597SitRevEsBaja ;
   private boolean brk1HL2 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV13TFSitRevDescrip_SelsJson ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV14TFSitRevDescrip ;
   private String AV38MenuOpcCod ;
   private String A1596SitRevDescrip ;
   private String AV45Situacionrevistaafipwwds_3_tfsitrevdescrip ;
   private String lV45Situacionrevistaafipwwds_3_tfsitrevdescrip ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01HL2_A1596SitRevDescrip ;
   private boolean[] P01HL2_A1597SitRevEsBaja ;
   private short[] P01HL2_A1595SitRevCodigo ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV15TFSitRevDescrip_Sels ;
   private GXSimpleCollection<String> AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class situacionrevistaafipwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01HL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1596SitRevDescrip ,
                                          GXSimpleCollection<String> AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels ,
                                          short AV43Situacionrevistaafipwwds_1_tfsitrevcodigo ,
                                          short AV44Situacionrevistaafipwwds_2_tfsitrevcodigo_to ,
                                          int AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels_size ,
                                          String AV45Situacionrevistaafipwwds_3_tfsitrevdescrip ,
                                          byte AV47Situacionrevistaafipwwds_5_tfsitrevesbaja_sel ,
                                          short A1595SitRevCodigo ,
                                          boolean A1597SitRevEsBaja )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT SitRevDescrip, SitRevEsBaja, SitRevCodigo FROM SituacionRevistaAFIP" ;
      if ( ! (0==AV43Situacionrevistaafipwwds_1_tfsitrevcodigo) )
      {
         addWhere(sWhereString, "(SitRevCodigo >= ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ! (0==AV44Situacionrevistaafipwwds_2_tfsitrevcodigo_to) )
      {
         addWhere(sWhereString, "(SitRevCodigo <= ?)");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( ( AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV45Situacionrevistaafipwwds_3_tfsitrevdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SitRevDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV46Situacionrevistaafipwwds_4_tfsitrevdescrip_sels, "SitRevDescrip IN (", ")")+")");
      }
      if ( AV47Situacionrevistaafipwwds_5_tfsitrevesbaja_sel == 1 )
      {
         addWhere(sWhereString, "(SitRevEsBaja = TRUE)");
      }
      if ( AV47Situacionrevistaafipwwds_5_tfsitrevesbaja_sel == 2 )
      {
         addWhere(sWhereString, "(SitRevEsBaja = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SitRevDescrip" ;
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
                  return conditional_P01HL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).byteValue() , ((Number) dynConstraints[7]).shortValue() , ((Boolean) dynConstraints[8]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01HL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
      }
   }

}

