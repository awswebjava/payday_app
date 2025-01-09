package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajolicenciaswcgetfilterdata extends GXProcedure
{
   public legajolicenciaswcgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajolicenciaswcgetfilterdata.class ), "" );
   }

   public legajolicenciaswcgetfilterdata( int remoteHandle ,
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
      legajolicenciaswcgetfilterdata.this.aP5 = new String[] {""};
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
      legajolicenciaswcgetfilterdata.this.AV20DDOName = aP0;
      legajolicenciaswcgetfilterdata.this.AV18SearchTxt = aP1;
      legajolicenciaswcgetfilterdata.this.AV19SearchTxtTo = aP2;
      legajolicenciaswcgetfilterdata.this.aP3 = aP3;
      legajolicenciaswcgetfilterdata.this.aP4 = aP4;
      legajolicenciaswcgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLegajoLicencias", GXv_boolean2) ;
      legajolicenciaswcgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV20DDOName), "DDO_LEGLICDESCRIP") == 0 )
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
      AV24OptionsJson = AV23Options.toJSonString(false) ;
      AV27OptionsDescJson = AV26OptionsDesc.toJSonString(false) ;
      AV29OptionIndexesJson = AV28OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("LegajoLicenciasWCGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "LegajoLicenciasWCGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("LegajoLicenciasWCGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENINI") == 0 )
         {
            AV11TFLegLicenIni = localUtil.ctod( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV12TFLegLicenIni_To = localUtil.ctod( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICENFIN") == 0 )
         {
            AV13TFLegLicenFin = localUtil.ctod( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
            AV14TFLegLicenFin_To = localUtil.ctod( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP") == 0 )
         {
            AV46TFLegLicDescrip = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLEGLICDESCRIP_SEL") == 0 )
         {
            AV45TFLegLicDescrip_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFLegLicDescrip_Sels.fromJSonString(AV45TFLegLicDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&CLICOD") == 0 )
         {
            AV36CliCod = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&EMPCOD") == 0 )
         {
            AV37EmpCod = (short)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&LEGNUMERO") == 0 )
         {
            AV38LegNumero = (int)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADLEGLICDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV46TFLegLicDescrip = AV18SearchTxt ;
      AV47TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A914LegLicDescrip ,
                                           AV47TFLegLicDescrip_Sels ,
                                           AV11TFLegLicenIni ,
                                           AV12TFLegLicenIni_To ,
                                           AV13TFLegLicenFin ,
                                           AV14TFLegLicenFin_To ,
                                           Integer.valueOf(AV47TFLegLicDescrip_Sels.size()) ,
                                           AV46TFLegLicDescrip ,
                                           A76LegLicenIni ,
                                           A481LegLicenFin ,
                                           Integer.valueOf(AV36CliCod) ,
                                           Short.valueOf(AV37EmpCod) ,
                                           Integer.valueOf(AV38LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV46TFLegLicDescrip = GXutil.concat( GXutil.rtrim( AV46TFLegLicDescrip), "%", "") ;
      /* Using cursor P00H52 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV36CliCod), Short.valueOf(AV37EmpCod), Integer.valueOf(AV38LegNumero), AV11TFLegLicenIni, AV12TFLegLicenIni_To, AV13TFLegLicenFin, AV14TFLegLicenFin_To, lV46TFLegLicDescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brkH52 = false ;
         A3CliCod = P00H52_A3CliCod[0] ;
         A1EmpCod = P00H52_A1EmpCod[0] ;
         A6LegNumero = P00H52_A6LegNumero[0] ;
         A914LegLicDescrip = P00H52_A914LegLicDescrip[0] ;
         A481LegLicenFin = P00H52_A481LegLicenFin[0] ;
         A76LegLicenIni = P00H52_A76LegLicenIni[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P00H52_A3CliCod[0] == A3CliCod ) && ( P00H52_A1EmpCod[0] == A1EmpCod ) && ( P00H52_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P00H52_A914LegLicDescrip[0], A914LegLicDescrip) == 0 ) )
         {
            brkH52 = false ;
            A76LegLicenIni = P00H52_A76LegLicenIni[0] ;
            AV30count = (long)(AV30count+1) ;
            brkH52 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A914LegLicDescrip)==0) )
         {
            AV22Option = A914LegLicDescrip ;
            AV23Options.add(AV22Option, 0);
            AV28OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brkH52 )
         {
            brkH52 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   protected void cleanup( )
   {
      this.aP3[0] = legajolicenciaswcgetfilterdata.this.AV24OptionsJson;
      this.aP4[0] = legajolicenciaswcgetfilterdata.this.AV27OptionsDescJson;
      this.aP5[0] = legajolicenciaswcgetfilterdata.this.AV29OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV24OptionsJson = "" ;
      AV27OptionsDescJson = "" ;
      AV29OptionIndexesJson = "" ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV11TFLegLicenIni = GXutil.nullDate() ;
      AV12TFLegLicenIni_To = GXutil.nullDate() ;
      AV13TFLegLicenFin = GXutil.nullDate() ;
      AV14TFLegLicenFin_To = GXutil.nullDate() ;
      AV46TFLegLicDescrip = "" ;
      AV45TFLegLicDescrip_SelsJson = "" ;
      AV47TFLegLicDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV46TFLegLicDescrip = "" ;
      A914LegLicDescrip = "" ;
      A76LegLicenIni = GXutil.nullDate() ;
      A481LegLicenFin = GXutil.nullDate() ;
      P00H52_A3CliCod = new int[1] ;
      P00H52_A1EmpCod = new short[1] ;
      P00H52_A6LegNumero = new int[1] ;
      P00H52_A914LegLicDescrip = new String[] {""} ;
      P00H52_A481LegLicenFin = new java.util.Date[] {GXutil.nullDate()} ;
      P00H52_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      AV22Option = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajolicenciaswcgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P00H52_A3CliCod, P00H52_A1EmpCod, P00H52_A6LegNumero, P00H52_A914LegLicDescrip, P00H52_A481LegLicenFin, P00H52_A76LegLicenIni
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV37EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV50GXV1 ;
   private int AV36CliCod ;
   private int AV38LegNumero ;
   private int AV47TFLegLicDescrip_Sels_size ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private long AV30count ;
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
   private boolean brkH52 ;
   private String AV24OptionsJson ;
   private String AV27OptionsDescJson ;
   private String AV29OptionIndexesJson ;
   private String AV45TFLegLicDescrip_SelsJson ;
   private String AV20DDOName ;
   private String AV18SearchTxt ;
   private String AV19SearchTxtTo ;
   private String AV46TFLegLicDescrip ;
   private String lV46TFLegLicDescrip ;
   private String A914LegLicDescrip ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00H52_A3CliCod ;
   private short[] P00H52_A1EmpCod ;
   private int[] P00H52_A6LegNumero ;
   private String[] P00H52_A914LegLicDescrip ;
   private java.util.Date[] P00H52_A481LegLicenFin ;
   private java.util.Date[] P00H52_A76LegLicenIni ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV26OptionsDesc ;
   private GXSimpleCollection<String> AV28OptionIndexes ;
   private GXSimpleCollection<String> AV47TFLegLicDescrip_Sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class legajolicenciaswcgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00H52( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A914LegLicDescrip ,
                                          GXSimpleCollection<String> AV47TFLegLicDescrip_Sels ,
                                          java.util.Date AV11TFLegLicenIni ,
                                          java.util.Date AV12TFLegLicenIni_To ,
                                          java.util.Date AV13TFLegLicenFin ,
                                          java.util.Date AV14TFLegLicenFin_To ,
                                          int AV47TFLegLicDescrip_Sels_size ,
                                          String AV46TFLegLicDescrip ,
                                          java.util.Date A76LegLicenIni ,
                                          java.util.Date A481LegLicenFin ,
                                          int AV36CliCod ,
                                          short AV37EmpCod ,
                                          int AV38LegNumero ,
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
      if ( ( AV47TFLegLicDescrip_Sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46TFLegLicDescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(LegLicDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV47TFLegLicDescrip_Sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47TFLegLicDescrip_Sels, "LegLicDescrip IN (", ")")+")");
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
                  return conditional_P00H52(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , (java.util.Date)dynConstraints[8] , (java.util.Date)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).shortValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00H52", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

