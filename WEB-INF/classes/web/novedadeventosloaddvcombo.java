package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class novedadeventosloaddvcombo extends GXProcedure
{
   public novedadeventosloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( novedadeventosloaddvcombo.class ), "" );
   }

   public novedadeventosloaddvcombo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             int aP7 ,
                             short aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      novedadeventosloaddvcombo.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        int aP5 ,
                        java.util.Date aP6 ,
                        int aP7 ,
                        short aP8 ,
                        String aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             int aP7 ,
                             short aP8 ,
                             String aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      novedadeventosloaddvcombo.this.AV15ComboName = aP0;
      novedadeventosloaddvcombo.this.AV16TrnMode = aP1;
      novedadeventosloaddvcombo.this.AV17IsDynamicCall = aP2;
      novedadeventosloaddvcombo.this.AV18CliCod = aP3;
      novedadeventosloaddvcombo.this.AV19EmpCod = aP4;
      novedadeventosloaddvcombo.this.AV20LegNumero = aP5;
      novedadeventosloaddvcombo.this.AV21LegLicenIni = aP6;
      novedadeventosloaddvcombo.this.AV28Cond_CliCod = aP7;
      novedadeventosloaddvcombo.this.AV29Cond_EmpCod = aP8;
      novedadeventosloaddvcombo.this.AV12SearchTxt = aP9;
      novedadeventosloaddvcombo.this.aP10 = aP10;
      novedadeventosloaddvcombo.this.aP11 = aP11;
      novedadeventosloaddvcombo.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWNovedadEventos", GXv_boolean2) ;
      novedadeventosloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "LegNumero") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGNUMERO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "LegLicSitCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_LEGLICSITCODIGO' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      if ( GXutil.strcmp(AV16TrnMode, "INS") == 0 )
      {
         GXv_char4[0] = AV22SelectedValue ;
         GXv_char5[0] = "" ;
         new web.dvcombodefaults(remoteHandle, context).execute( AV15ComboName, GXv_char4, GXv_char5) ;
         novedadeventosloaddvcombo.this.AV22SelectedValue = GXv_char4[0] ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_LEGNUMERO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A250LegIdNomApe ,
                                              Integer.valueOf(A3CliCod) ,
                                              Integer.valueOf(AV28Cond_CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Short.valueOf(AV29Cond_EmpCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P013S2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV28Cond_CliCod), Short.valueOf(AV29Cond_EmpCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P013S2_A3CliCod[0] ;
            A1EmpCod = P013S2_A1EmpCod[0] ;
            A250LegIdNomApe = P013S2_A250LegIdNomApe[0] ;
            A6LegNumero = P013S2_A6LegNumero[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A6LegNumero, 8, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A250LegIdNomApe );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV24Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P013S3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV21LegLicenIni});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A76LegLicenIni = P013S3_A76LegLicenIni[0] ;
               A6LegNumero = P013S3_A6LegNumero[0] ;
               A1EmpCod = P013S3_A1EmpCod[0] ;
               A3CliCod = P013S3_A3CliCod[0] ;
               A250LegIdNomApe = P013S3_A250LegIdNomApe[0] ;
               A250LegIdNomApe = P013S3_A250LegIdNomApe[0] ;
               AV22SelectedValue = ((0==A6LegNumero) ? "" : GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
               AV23SelectedText = A250LegIdNomApe ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV20LegNumero) )
            {
               AV22SelectedValue = GXutil.trim( GXutil.str( AV20LegNumero, 8, 0)) ;
               /* Using cursor P013S4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV28Cond_CliCod), Short.valueOf(AV29Cond_EmpCod), Integer.valueOf(AV20LegNumero)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1EmpCod = P013S4_A1EmpCod[0] ;
                  A3CliCod = P013S4_A3CliCod[0] ;
                  A6LegNumero = P013S4_A6LegNumero[0] ;
                  A250LegIdNomApe = P013S4_A250LegIdNomApe[0] ;
                  AV23SelectedText = A250LegIdNomApe ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(2);
            }
         }
      }
   }

   public void S121( )
   {
      /* 'LOADCOMBOITEMS_LEGLICSITCODIGO' Routine */
      returnInSub = false ;
      /* Using cursor P013S5 */
      pr_default.execute(3);
      while ( (pr_default.getStatus(3) != 101) )
      {
         A16SitCodigo = P013S5_A16SitCodigo[0] ;
         A913sItDescAbrev = P013S5_A913sItDescAbrev[0] ;
         AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A16SitCodigo );
         AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A913sItDescAbrev );
         AV13Combo_Data.add(AV14Combo_DataItem, 0);
         pr_default.readNext(3);
      }
      pr_default.close(3);
      AV24Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
      {
         /* Using cursor P013S6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), Integer.valueOf(AV20LegNumero), AV21LegLicenIni});
         while ( (pr_default.getStatus(4) != 101) )
         {
            A76LegLicenIni = P013S6_A76LegLicenIni[0] ;
            A6LegNumero = P013S6_A6LegNumero[0] ;
            A1EmpCod = P013S6_A1EmpCod[0] ;
            A3CliCod = P013S6_A3CliCod[0] ;
            A506LegLicSitCodigo = P013S6_A506LegLicSitCodigo[0] ;
            AV22SelectedValue = A506LegLicSitCodigo ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(4);
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = novedadeventosloaddvcombo.this.AV22SelectedValue;
      this.aP11[0] = novedadeventosloaddvcombo.this.AV23SelectedText;
      this.aP12[0] = novedadeventosloaddvcombo.this.AV24Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22SelectedValue = "" ;
      AV23SelectedText = "" ;
      AV24Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A250LegIdNomApe = "" ;
      P013S2_A3CliCod = new int[1] ;
      P013S2_A1EmpCod = new short[1] ;
      P013S2_A250LegIdNomApe = new String[] {""} ;
      P013S2_A6LegNumero = new int[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P013S3_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P013S3_A6LegNumero = new int[1] ;
      P013S3_A1EmpCod = new short[1] ;
      P013S3_A3CliCod = new int[1] ;
      P013S3_A250LegIdNomApe = new String[] {""} ;
      A76LegLicenIni = GXutil.nullDate() ;
      P013S4_A1EmpCod = new short[1] ;
      P013S4_A3CliCod = new int[1] ;
      P013S4_A6LegNumero = new int[1] ;
      P013S4_A250LegIdNomApe = new String[] {""} ;
      P013S5_A16SitCodigo = new String[] {""} ;
      P013S5_A913sItDescAbrev = new String[] {""} ;
      A16SitCodigo = "" ;
      A913sItDescAbrev = "" ;
      P013S6_A76LegLicenIni = new java.util.Date[] {GXutil.nullDate()} ;
      P013S6_A6LegNumero = new int[1] ;
      P013S6_A1EmpCod = new short[1] ;
      P013S6_A3CliCod = new int[1] ;
      P013S6_A506LegLicSitCodigo = new String[] {""} ;
      A506LegLicSitCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.novedadeventosloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P013S2_A3CliCod, P013S2_A1EmpCod, P013S2_A250LegIdNomApe, P013S2_A6LegNumero
            }
            , new Object[] {
            P013S3_A76LegLicenIni, P013S3_A6LegNumero, P013S3_A1EmpCod, P013S3_A3CliCod, P013S3_A250LegIdNomApe
            }
            , new Object[] {
            P013S4_A1EmpCod, P013S4_A3CliCod, P013S4_A6LegNumero, P013S4_A250LegIdNomApe
            }
            , new Object[] {
            P013S5_A16SitCodigo, P013S5_A913sItDescAbrev
            }
            , new Object[] {
            P013S6_A76LegLicenIni, P013S6_A6LegNumero, P013S6_A1EmpCod, P013S6_A3CliCod, P013S6_A506LegLicSitCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19EmpCod ;
   private short AV29Cond_EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV20LegNumero ;
   private int AV28Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV16TrnMode ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private String scmdbuf ;
   private String A16SitCodigo ;
   private String A506LegLicSitCodigo ;
   private java.util.Date AV21LegLicenIni ;
   private java.util.Date A76LegLicenIni ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV24Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV22SelectedValue ;
   private String AV23SelectedText ;
   private String lV12SearchTxt ;
   private String A250LegIdNomApe ;
   private String A913sItDescAbrev ;
   private String[] aP12 ;
   private String[] aP10 ;
   private String[] aP11 ;
   private IDataStoreProvider pr_default ;
   private int[] P013S2_A3CliCod ;
   private short[] P013S2_A1EmpCod ;
   private String[] P013S2_A250LegIdNomApe ;
   private int[] P013S2_A6LegNumero ;
   private java.util.Date[] P013S3_A76LegLicenIni ;
   private int[] P013S3_A6LegNumero ;
   private short[] P013S3_A1EmpCod ;
   private int[] P013S3_A3CliCod ;
   private String[] P013S3_A250LegIdNomApe ;
   private short[] P013S4_A1EmpCod ;
   private int[] P013S4_A3CliCod ;
   private int[] P013S4_A6LegNumero ;
   private String[] P013S4_A250LegIdNomApe ;
   private String[] P013S5_A16SitCodigo ;
   private String[] P013S5_A913sItDescAbrev ;
   private java.util.Date[] P013S6_A76LegLicenIni ;
   private int[] P013S6_A6LegNumero ;
   private short[] P013S6_A1EmpCod ;
   private int[] P013S6_A3CliCod ;
   private String[] P013S6_A506LegLicSitCodigo ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class novedadeventosloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P013S2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A250LegIdNomApe ,
                                          int A3CliCod ,
                                          int AV28Cond_CliCod ,
                                          short A1EmpCod ,
                                          short AV29Cond_EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[3];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegIdNomApe, LegNumero FROM Legajo" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(LegIdNomApe) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY LegIdNomApe" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
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
                  return conditional_P013S2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P013S2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P013S3", "SELECT T1.LegLicenIni, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LegIdNomApe FROM (LegajoLicencias T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LegLicenIni = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LegLicenIni ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P013S4", "SELECT EmpCod, CliCod, LegNumero, LegIdNomApe FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P013S5", "SELECT SitCodigo, sItDescAbrev FROM Estado ORDER BY sItDescAbrev ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P013S6", "SELECT LegLicenIni, LegNumero, EmpCod, CliCod, LegLicSitCodigo FROM LegajoLicencias WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and LegLicenIni = ? ORDER BY CliCod, EmpCod, LegNumero, LegLicenIni ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 4);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
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
                  stmt.setVarchar(sIdx, (String)parms[5], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

