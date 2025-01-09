package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class embargabilidadloaddvcombo extends GXProcedure
{
   public embargabilidadloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( embargabilidadloaddvcombo.class ), "" );
   }

   public embargabilidadloaddvcombo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      embargabilidadloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      embargabilidadloaddvcombo.this.AV15ComboName = aP0;
      embargabilidadloaddvcombo.this.AV16TrnMode = aP1;
      embargabilidadloaddvcombo.this.AV17IsDynamicCall = aP2;
      embargabilidadloaddvcombo.this.AV18EmbargaSec = aP3;
      embargabilidadloaddvcombo.this.AV12SearchTxt = aP4;
      embargabilidadloaddvcombo.this.aP5 = aP5;
      embargabilidadloaddvcombo.this.aP6 = aP6;
      embargabilidadloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWembargabilidad", GXv_boolean2) ;
      embargabilidadloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "EmbarPaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_EMBARPAICOD' */
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
      /* 'LOADCOMBOITEMS_EMBARPAICOD' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A312PaiNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P019H2 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A312PaiNom = P019H2_A312PaiNom[0] ;
            A46PaiCod = P019H2_A46PaiCod[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A46PaiCod, 4, 0)) );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A312PaiNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV21Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            if ( GXutil.strcmp(AV16TrnMode, "GET") != 0 )
            {
               /* Using cursor P019H3 */
               pr_default.execute(1, new Object[] {Short.valueOf(AV18EmbargaSec)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A1161EmbargaSec = P019H3_A1161EmbargaSec[0] ;
                  A1160EmbarPaiCod = P019H3_A1160EmbarPaiCod[0] ;
                  AV19SelectedValue = ((0==A1160EmbarPaiCod) ? "" : GXutil.trim( GXutil.str( A1160EmbarPaiCod, 4, 0))) ;
                  AV25PaiCod = A1160EmbarPaiCod ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV25PaiCod = (short)(GXutil.lval( AV12SearchTxt)) ;
            }
            /* Using cursor P019H4 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV25PaiCod)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A46PaiCod = P019H4_A46PaiCod[0] ;
               A312PaiNom = P019H4_A312PaiNom[0] ;
               AV20SelectedText = A312PaiNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
      }
   }

   protected void cleanup( )
   {
      this.aP5[0] = embargabilidadloaddvcombo.this.AV19SelectedValue;
      this.aP6[0] = embargabilidadloaddvcombo.this.AV20SelectedText;
      this.aP7[0] = embargabilidadloaddvcombo.this.AV21Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19SelectedValue = "" ;
      AV20SelectedText = "" ;
      AV21Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A312PaiNom = "" ;
      P019H2_A312PaiNom = new String[] {""} ;
      P019H2_A46PaiCod = new short[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P019H3_A1161EmbargaSec = new short[1] ;
      P019H3_A1160EmbarPaiCod = new short[1] ;
      P019H4_A46PaiCod = new short[1] ;
      P019H4_A312PaiNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.embargabilidadloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P019H2_A312PaiNom, P019H2_A46PaiCod
            }
            , new Object[] {
            P019H3_A1161EmbargaSec, P019H3_A1160EmbarPaiCod
            }
            , new Object[] {
            P019H4_A46PaiCod, P019H4_A312PaiNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18EmbargaSec ;
   private short A46PaiCod ;
   private short A1161EmbargaSec ;
   private short A1160EmbarPaiCod ;
   private short AV25PaiCod ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV21Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV19SelectedValue ;
   private String AV20SelectedText ;
   private String lV12SearchTxt ;
   private String A312PaiNom ;
   private String[] aP7 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private String[] P019H2_A312PaiNom ;
   private short[] P019H2_A46PaiCod ;
   private short[] P019H3_A1161EmbargaSec ;
   private short[] P019H3_A1160EmbarPaiCod ;
   private short[] P019H4_A46PaiCod ;
   private String[] P019H4_A312PaiNom ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class embargabilidadloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P019H2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A312PaiNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT PaiNom, PaiCod FROM Pais" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(PaiNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiNom" ;
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
                  return conditional_P019H2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019H2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P019H3", "SELECT EmbargaSec, EmbarPaiCod FROM embargabilidad WHERE EmbargaSec = ? ORDER BY EmbargaSec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019H4", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

