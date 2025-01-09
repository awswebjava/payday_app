package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class licenciaswcgetfilterdata extends GXProcedure
{
   public licenciaswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licenciaswcgetfilterdata.class ), "" );
   }

   public licenciaswcgetfilterdata( int remoteHandle ,
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
      licenciaswcgetfilterdata.this.aP5 = new String[] {""};
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
      licenciaswcgetfilterdata.this.AV30DDOName = aP0;
      licenciaswcgetfilterdata.this.AV31SearchTxt = aP1;
      licenciaswcgetfilterdata.this.AV32SearchTxtTo = aP2;
      licenciaswcgetfilterdata.this.aP3 = aP3;
      licenciaswcgetfilterdata.this.aP4 = aP4;
      licenciaswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias", GXv_boolean2) ;
      licenciaswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV30DDOName), "DDO_LEGLICDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADLEGLICDESCRIPOPTIONS' */
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
      if ( GXutil.strcmp(AV25Session.getValue("licenciasWCGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "licenciasWCGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV25Session.getValue("licenciasWCGridState"), null, null);
      }
      AV42GXV1 = 1 ;
      while ( AV42GXV1 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV28GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV42GXV1));
         if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENINI") == 0 )
         {
            AV11TFLegLicenIni = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV12TFLegLicenIni_To = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENFIN") == 0 )
         {
            AV13TFLegLicenFin = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV14TFLegLicenFin_To = localUtil.ctod( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP") == 0 )
         {
            AV16TFLegLicDescrip = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP_SEL") == 0 )
         {
            AV15TFLegLicDescrip_SelsJson = AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFLegLicDescrip_Sels.fromJSonString(AV15TFLegLicDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV36CliCod = (int)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV37EmpCod = (short)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV39LegNumero = (int)(GXutil.lval( AV28GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV42GXV1 = (int)(AV42GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGLICDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV16TFLegLicDescrip = AV31SearchTxt ;
      AV17TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A914LegLicDescrip ,
                                           AV17TFLegLicDescrip_Sels ,
                                           AV11TFLegLicenIni ,
                                           AV12TFLegLicenIni_To ,
                                           AV13TFLegLicenFin ,
                                           AV14TFLegLicenFin_To ,
                                           Integer.valueOf(AV17TFLegLicDescrip_Sels.size()) ,
                                           AV16TFLegLicDescrip ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Integer.valueOf(AV36CliCod) ,
                                           Short.valueOf(AV37EmpCod) ,
                                           Integer.valueOf(AV39LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV16TFLegLicDescrip = GXutil.concat( GXutil.rtrim( AV16TFLegLicDescrip), "%", "") ;
      /* Using cursor P01QN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliCod), Short.valueOf(AV37EmpCod), Integer.valueOf(AV39LegNumero), AV11TFLegLicenIni, AV12TFLegLicenIni_To, AV13TFLegLicenFin, AV14TFLegLicenFin_To, lV16TFLegLicDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1QN2 = false ;
         A3CliCod = P01QN2_A3CliCod[0] ;
         A1EmpCod = P01QN2_A1EmpCod[0] ;
         A6LegNumero = P01QN2_A6LegNumero[0] ;
         A914LegLicDescrip = P01QN2_A914LegLicDescrip[0] ;
         A481LegLicenFin = P01QN2_A481LegLicenFin[0] ;
         A76LegLicenIni = P01QN2_A76LegLicenIni[0] ;
         AV24count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P01QN2_A3CliCod[0] == A3CliCod ) && ( P01QN2_A1EmpCod[0] == A1EmpCod ) && ( P01QN2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01QN2_A914LegLicDescrip[0], A914LegLicDescrip) == 0 ) )
         {
            brk1QN2 = false ;
            A76LegLicenIni = P01QN2_A76LegLicenIni[0] ;
            AV24count = (long)(AV24count+1) ;
            brk1QN2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A914LegLicDescrip)==0) )
         {
            AV19Option = A914LegLicDescrip ;
            AV20Options.add(AV19Option, 0);
            AV23OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV24count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1QN2 )
         {
            brk1QN2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = licenciaswcgetfilterdata.this.AV33OptionsJson;
      this.aP4[0] = licenciaswcgetfilterdata.this.AV34OptionsDescJson;
      this.aP5[0] = licenciaswcgetfilterdata.this.AV35OptionIndexesJson;
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
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV25Session = httpContext.getWebSession();
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFLegLicenIni = GXutil.nullDate() ;
      AV12TFLegLicenIni_To = GXutil.nullDate() ;
      AV13TFLegLicenFin = GXutil.nullDate() ;
      AV14TFLegLicenFin_To = GXutil.nullDate() ;
      AV16TFLegLicDescrip = "" ;
      AV15TFLegLicDescrip_SelsJson = "" ;
      AV17TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV16TFLegLicDescrip = "" ;
      A914LegLicDescrip = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      P01QN2_A3CliCod = new int[1] ;
      P01QN2_A1EmpCod = new short[1] ;
      P01QN2_A6LegNumero = new int[1] ;
      P01QN2_A914LegLicDescrip = new String[] {""} ;
      P01QN2_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P01QN2_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      AV19Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licenciaswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01QN2_A3CliCod, P01QN2_A1EmpCod, P01QN2_A6LegNumero, P01QN2_A914LegLicDescrip, P01QN2_A481LegLicenFin, P01QN2_A76LegLicenIni
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV42GXV1 ;
   private int AV36CliCod ;
   private int AV39LegNumero ;
   private int AV17TFLegLicDescrip_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private long AV24count ;
   private String scmdbuf ;
   private java.util.Date AV11TFLegLicenIni ;
   private java.util.Date AV12TFLegLicenIni_To ;
   private java.util.Date AV13TFLegLicenFin ;
   private java.util.Date AV14TFLegLicenFin_To ;
   private java.util.Date A76LegLicenIni ;
   private java.util.Date A481LegLicenFin ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean brk1QN2 ;
   private String AV33OptionsJson ;
   private String AV34OptionsDescJson ;
   private String AV35OptionIndexesJson ;
   private String AV15TFLegLicDescrip_SelsJson ;
   private String AV30DDOName ;
   private String AV31SearchTxt ;
   private String AV32SearchTxtTo ;
   private String AV16TFLegLicDescrip ;
   private String lV16TFLegLicDescrip ;
   private String A914LegLicDescrip ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV25Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P01QN2_A3CliCod ;
   private short[] P01QN2_A1EmpCod ;
   private int[] P01QN2_A6LegNumero ;
   private String[] P01QN2_A914LegLicDescrip ;
   private java.util.Date[] P01QN2_A481LegLicenFin ;
   private java.util.Date[] P01QN2_A76LegLicenIni ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV23OptionIndexes ;
   private GXSimpleCollection<String> AV17TFLegLicDescrip_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV28GridStateFilterValue ;
}

final  class licenciaswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01QN2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV17TFLegLicDescrip_Sels ,
                                          java.util.Date AV11TFLegLicenIni ,
                                          java.util.Date AV12TFLegLicenIni_To ,
                                          java.util.Date AV13TFLegLicenFin ,
                                          java.util.Date AV14TFLegLicenFin_To ,
                                          int AV17TFLegLicDescrip_Sels_size ,
                                          String AV16TFLegLicDescrip ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          int AV36CliCod ,
                                          short AV37EmpCod ,
                                          int AV39LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegNumero, LegLicDescrip, LegLicenFin, LegLicenIni FROM LegajoLicencias" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV11TFLegLicenIni)) )
      {
         addWhere(sWhereString, "(LegLicenIni >= ?)");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV12TFLegLicenIni_To)) )
      {
         addWhere(sWhereString, "(LegLicenIni <= ?)");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV13TFLegLicenFin)) )
      {
         addWhere(sWhereString, "(LegLicenFin >= ?)");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV14TFLegLicenFin_To)) )
      {
         addWhere(sWhereString, "(LegLicenFin <= ?)");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( ( AV17TFLegLicDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV16TFLegLicDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV17TFLegLicDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV17TFLegLicDescrip_Sels, "LegLicDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero, LegLicDescrip" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01QN2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01QN2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[11]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 400);
               }
               return;
      }
   }

}

