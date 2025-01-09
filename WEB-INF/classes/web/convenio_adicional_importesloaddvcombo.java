package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convenio_adicional_importesloaddvcombo extends GXProcedure
{
   public convenio_adicional_importesloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_importesloaddvcombo.class ), "" );
   }

   public convenio_adicional_importesloaddvcombo( int remoteHandle ,
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
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             int aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String[] aP12 ,
                             String[] aP13 )
   {
      convenio_adicional_importesloaddvcombo.this.aP14 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        int aP8 ,
                        short aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             int aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 )
   {
      convenio_adicional_importesloaddvcombo.this.AV15ComboName = aP0;
      convenio_adicional_importesloaddvcombo.this.AV16TrnMode = aP1;
      convenio_adicional_importesloaddvcombo.this.AV17IsDynamicCall = aP2;
      convenio_adicional_importesloaddvcombo.this.AV32CliCod = aP3;
      convenio_adicional_importesloaddvcombo.this.AV34CliPaiConve = aP4;
      convenio_adicional_importesloaddvcombo.this.AV35CliConvenio = aP5;
      convenio_adicional_importesloaddvcombo.this.AV20ConveAdicod = aP6;
      convenio_adicional_importesloaddvcombo.this.AV21ConveAdiVig = aP7;
      convenio_adicional_importesloaddvcombo.this.AV36Cond_CliCod = aP8;
      convenio_adicional_importesloaddvcombo.this.AV37Cond_CliPaiConve = aP9;
      convenio_adicional_importesloaddvcombo.this.AV38Cond_CliConvenio = aP10;
      convenio_adicional_importesloaddvcombo.this.AV12SearchTxt = aP11;
      convenio_adicional_importesloaddvcombo.this.aP12 = aP12;
      convenio_adicional_importesloaddvcombo.this.aP13 = aP13;
      convenio_adicional_importesloaddvcombo.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Adicional_Importes", GXv_boolean2) ;
      convenio_adicional_importesloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "ConveAdicod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CONVEADICOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADCOMBOITEMS_CONVEADICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A997ConveAdiDescri ,
                                              Integer.valueOf(A3CliCod) ,
                                              Integer.valueOf(AV36Cond_CliCod) ,
                                              Short.valueOf(A1564CliPaiConve) ,
                                              Short.valueOf(AV37Cond_CliPaiConve) ,
                                              A1565CliConvenio ,
                                              AV38Cond_CliConvenio } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P013C2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV36Cond_CliCod), Short.valueOf(AV37Cond_CliPaiConve), AV38Cond_CliConvenio, lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P013C2_A3CliCod[0] ;
            A1564CliPaiConve = P013C2_A1564CliPaiConve[0] ;
            A1565CliConvenio = P013C2_A1565CliConvenio[0] ;
            A997ConveAdiDescri = P013C2_A997ConveAdiDescri[0] ;
            A996ConveAdicod = P013C2_A996ConveAdicod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A996ConveAdicod );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A997ConveAdiDescri );
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
            /* Using cursor P013C3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV32CliCod), Short.valueOf(AV34CliPaiConve), AV35CliConvenio, AV20ConveAdicod, AV21ConveAdiVig});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A999ConveAdiVig = P013C3_A999ConveAdiVig[0] ;
               A996ConveAdicod = P013C3_A996ConveAdicod[0] ;
               A1565CliConvenio = P013C3_A1565CliConvenio[0] ;
               A1564CliPaiConve = P013C3_A1564CliPaiConve[0] ;
               A3CliCod = P013C3_A3CliCod[0] ;
               A997ConveAdiDescri = P013C3_A997ConveAdiDescri[0] ;
               A997ConveAdiDescri = P013C3_A997ConveAdiDescri[0] ;
               AV22SelectedValue = A996ConveAdicod ;
               AV23SelectedText = A997ConveAdiDescri ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV20ConveAdicod)==0) )
            {
               AV22SelectedValue = AV20ConveAdicod ;
               /* Using cursor P013C4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV36Cond_CliCod), Short.valueOf(AV37Cond_CliPaiConve), AV38Cond_CliConvenio, AV20ConveAdicod});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1565CliConvenio = P013C4_A1565CliConvenio[0] ;
                  A1564CliPaiConve = P013C4_A1564CliPaiConve[0] ;
                  A3CliCod = P013C4_A3CliCod[0] ;
                  A996ConveAdicod = P013C4_A996ConveAdicod[0] ;
                  A997ConveAdiDescri = P013C4_A997ConveAdiDescri[0] ;
                  AV23SelectedText = A997ConveAdiDescri ;
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

   protected void cleanup( )
   {
      this.aP12[0] = convenio_adicional_importesloaddvcombo.this.AV22SelectedValue;
      this.aP13[0] = convenio_adicional_importesloaddvcombo.this.AV23SelectedText;
      this.aP14[0] = convenio_adicional_importesloaddvcombo.this.AV24Combo_DataJson;
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
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A997ConveAdiDescri = "" ;
      A1565CliConvenio = "" ;
      P013C2_A3CliCod = new int[1] ;
      P013C2_A1564CliPaiConve = new short[1] ;
      P013C2_A1565CliConvenio = new String[] {""} ;
      P013C2_A997ConveAdiDescri = new String[] {""} ;
      P013C2_A996ConveAdicod = new String[] {""} ;
      A996ConveAdicod = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P013C3_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      P013C3_A996ConveAdicod = new String[] {""} ;
      P013C3_A1565CliConvenio = new String[] {""} ;
      P013C3_A1564CliPaiConve = new short[1] ;
      P013C3_A3CliCod = new int[1] ;
      P013C3_A997ConveAdiDescri = new String[] {""} ;
      A999ConveAdiVig = GXutil.nullDate() ;
      P013C4_A1565CliConvenio = new String[] {""} ;
      P013C4_A1564CliPaiConve = new short[1] ;
      P013C4_A3CliCod = new int[1] ;
      P013C4_A996ConveAdicod = new String[] {""} ;
      P013C4_A997ConveAdiDescri = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional_importesloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P013C2_A3CliCod, P013C2_A1564CliPaiConve, P013C2_A1565CliConvenio, P013C2_A997ConveAdiDescri, P013C2_A996ConveAdicod
            }
            , new Object[] {
            P013C3_A999ConveAdiVig, P013C3_A996ConveAdicod, P013C3_A1565CliConvenio, P013C3_A1564CliPaiConve, P013C3_A3CliCod, P013C3_A997ConveAdiDescri
            }
            , new Object[] {
            P013C4_A1565CliConvenio, P013C4_A1564CliPaiConve, P013C4_A3CliCod, P013C4_A996ConveAdicod, P013C4_A997ConveAdiDescri
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV34CliPaiConve ;
   private short AV37Cond_CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV32CliCod ;
   private int AV36Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV35CliConvenio ;
   private String AV20ConveAdicod ;
   private String AV38Cond_CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private java.util.Date AV21ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
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
   private String A997ConveAdiDescri ;
   private String[] aP14 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private IDataStoreProvider pr_default ;
   private int[] P013C2_A3CliCod ;
   private short[] P013C2_A1564CliPaiConve ;
   private String[] P013C2_A1565CliConvenio ;
   private String[] P013C2_A997ConveAdiDescri ;
   private String[] P013C2_A996ConveAdicod ;
   private java.util.Date[] P013C3_A999ConveAdiVig ;
   private String[] P013C3_A996ConveAdicod ;
   private String[] P013C3_A1565CliConvenio ;
   private short[] P013C3_A1564CliPaiConve ;
   private int[] P013C3_A3CliCod ;
   private String[] P013C3_A997ConveAdiDescri ;
   private String[] P013C4_A1565CliConvenio ;
   private short[] P013C4_A1564CliPaiConve ;
   private int[] P013C4_A3CliCod ;
   private String[] P013C4_A996ConveAdicod ;
   private String[] P013C4_A997ConveAdiDescri ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class convenio_adicional_importesloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P013C2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A997ConveAdiDescri ,
                                          int A3CliCod ,
                                          int AV36Cond_CliCod ,
                                          short A1564CliPaiConve ,
                                          short AV37Cond_CliPaiConve ,
                                          String A1565CliConvenio ,
                                          String AV38Cond_CliConvenio )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[4];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdiDescri, ConveAdicod FROM convenio_adicional" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(CliPaiConve = ?)");
      addWhere(sWhereString, "(CliConvenio = ( ?))");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ConveAdiDescri) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ConveAdiDescri" ;
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
                  return conditional_P013C2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , (String)dynConstraints[7] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P013C2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P013C3", "SELECT T1.ConveAdiVig, T1.ConveAdicod, T1.CliConvenio, T1.CliPaiConve, T1.CliCod, T2.ConveAdiDescri FROM (convenio_adicionalimportes T1 INNER JOIN convenio_adicional T2 ON T2.CliCod = T1.CliCod AND T2.CliPaiConve = T1.CliPaiConve AND T2.CliConvenio = T1.CliConvenio AND T2.ConveAdicod = T1.ConveAdicod) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.ConveAdicod = ( ?) and T1.ConveAdiVig = ? ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.ConveAdicod, T1.ConveAdiVig ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P013C4", "SELECT CliConvenio, CliPaiConve, CliCod, ConveAdicod, ConveAdiDescri FROM convenio_adicional WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 1 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               return;
            case 2 :
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 20);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

