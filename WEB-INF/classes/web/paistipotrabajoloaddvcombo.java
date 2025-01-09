package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paistipotrabajoloaddvcombo extends GXProcedure
{
   public paistipotrabajoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paistipotrabajoloaddvcombo.class ), "" );
   }

   public paistipotrabajoloaddvcombo( int remoteHandle ,
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
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      paistipotrabajoloaddvcombo.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 )
   {
      paistipotrabajoloaddvcombo.this.AV15ComboName = aP0;
      paistipotrabajoloaddvcombo.this.AV16TrnMode = aP1;
      paistipotrabajoloaddvcombo.this.AV17IsDynamicCall = aP2;
      paistipotrabajoloaddvcombo.this.AV18PaiCod = aP3;
      paistipotrabajoloaddvcombo.this.AV19PaiTipoTraId = aP4;
      paistipotrabajoloaddvcombo.this.AV12SearchTxt = aP5;
      paistipotrabajoloaddvcombo.this.aP6 = aP6;
      paistipotrabajoloaddvcombo.this.aP7 = aP7;
      paistipotrabajoloaddvcombo.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPaisTipoTrabajo", GXv_boolean2) ;
      paistipotrabajoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "PaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAICOD' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(AV15ComboName, "PaiTipoTraId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAITIPOTRAID' */
            S121 ();
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
      /* 'LOADCOMBOITEMS_PAICOD' Routine */
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
         /* Using cursor P01I62 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A312PaiNom = P01I62_A312PaiNom[0] ;
            A46PaiCod = P01I62_A46PaiCod[0] ;
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
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01I63 */
            pr_default.execute(1, new Object[] {Short.valueOf(AV18PaiCod), AV19PaiTipoTraId});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1294PaiTipoTraId = P01I63_A1294PaiTipoTraId[0] ;
               A46PaiCod = P01I63_A46PaiCod[0] ;
               A312PaiNom = P01I63_A312PaiNom[0] ;
               A312PaiNom = P01I63_A312PaiNom[0] ;
               AV20SelectedValue = ((0==A46PaiCod) ? "" : GXutil.trim( GXutil.str( A46PaiCod, 4, 0))) ;
               AV21SelectedText = A312PaiNom ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV18PaiCod) )
            {
               AV20SelectedValue = GXutil.trim( GXutil.str( AV18PaiCod, 4, 0)) ;
               /* Using cursor P01I64 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV18PaiCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A46PaiCod = P01I64_A46PaiCod[0] ;
                  A312PaiNom = P01I64_A312PaiNom[0] ;
                  AV21SelectedText = A312PaiNom ;
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
      /* 'LOADCOMBOITEMS_PAITIPOTRAID' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(3, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1293TipoTraNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01I65 */
         pr_default.execute(3, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A1293TipoTraNom = P01I65_A1293TipoTraNom[0] ;
            A1292TipoTraId = P01I65_A1292TipoTraId[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1292TipoTraId );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1293TipoTraNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(3);
         }
         pr_default.close(3);
         AV22Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01I66 */
            pr_default.execute(4, new Object[] {Short.valueOf(AV18PaiCod), AV19PaiTipoTraId});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A1294PaiTipoTraId = P01I66_A1294PaiTipoTraId[0] ;
               A46PaiCod = P01I66_A46PaiCod[0] ;
               AV20SelectedValue = A1294PaiTipoTraId ;
               AV26TipoTraId = A1294PaiTipoTraId ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(4);
            /* Using cursor P01I67 */
            pr_default.execute(5, new Object[] {AV26TipoTraId});
            while ( (pr_default.getStatus(5) != 101) )
            {
               A1292TipoTraId = P01I67_A1292TipoTraId[0] ;
               A1293TipoTraNom = P01I67_A1293TipoTraNom[0] ;
               AV21SelectedText = A1293TipoTraNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(5);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV19PaiTipoTraId)==0) )
            {
               AV20SelectedValue = AV19PaiTipoTraId ;
               /* Using cursor P01I68 */
               pr_default.execute(6, new Object[] {AV19PaiTipoTraId});
               while ( (pr_default.getStatus(6) != 101) )
               {
                  A1292TipoTraId = P01I68_A1292TipoTraId[0] ;
                  A1293TipoTraNom = P01I68_A1293TipoTraNom[0] ;
                  AV21SelectedText = A1293TipoTraNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(6);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = paistipotrabajoloaddvcombo.this.AV20SelectedValue;
      this.aP7[0] = paistipotrabajoloaddvcombo.this.AV21SelectedText;
      this.aP8[0] = paistipotrabajoloaddvcombo.this.AV22Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV22Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A312PaiNom = "" ;
      P01I62_A312PaiNom = new String[] {""} ;
      P01I62_A46PaiCod = new short[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01I63_A1294PaiTipoTraId = new String[] {""} ;
      P01I63_A46PaiCod = new short[1] ;
      P01I63_A312PaiNom = new String[] {""} ;
      A1294PaiTipoTraId = "" ;
      P01I64_A46PaiCod = new short[1] ;
      P01I64_A312PaiNom = new String[] {""} ;
      A1293TipoTraNom = "" ;
      P01I65_A1293TipoTraNom = new String[] {""} ;
      P01I65_A1292TipoTraId = new String[] {""} ;
      A1292TipoTraId = "" ;
      P01I66_A1294PaiTipoTraId = new String[] {""} ;
      P01I66_A46PaiCod = new short[1] ;
      AV26TipoTraId = "" ;
      P01I67_A1292TipoTraId = new String[] {""} ;
      P01I67_A1293TipoTraNom = new String[] {""} ;
      P01I68_A1292TipoTraId = new String[] {""} ;
      P01I68_A1293TipoTraNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paistipotrabajoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01I62_A312PaiNom, P01I62_A46PaiCod
            }
            , new Object[] {
            P01I63_A1294PaiTipoTraId, P01I63_A46PaiCod, P01I63_A312PaiNom
            }
            , new Object[] {
            P01I64_A46PaiCod, P01I64_A312PaiNom
            }
            , new Object[] {
            P01I65_A1293TipoTraNom, P01I65_A1292TipoTraId
            }
            , new Object[] {
            P01I66_A1294PaiTipoTraId, P01I66_A46PaiCod
            }
            , new Object[] {
            P01I67_A1292TipoTraId, P01I67_A1293TipoTraNom
            }
            , new Object[] {
            P01I68_A1292TipoTraId, P01I68_A1293TipoTraNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV18PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV16TrnMode ;
   private String AV19PaiTipoTraId ;
   private String scmdbuf ;
   private String A1294PaiTipoTraId ;
   private String A1292TipoTraId ;
   private String AV26TipoTraId ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV22Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV20SelectedValue ;
   private String AV21SelectedText ;
   private String lV12SearchTxt ;
   private String A312PaiNom ;
   private String A1293TipoTraNom ;
   private String[] aP8 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private IDataStoreProvider pr_default ;
   private String[] P01I62_A312PaiNom ;
   private short[] P01I62_A46PaiCod ;
   private String[] P01I63_A1294PaiTipoTraId ;
   private short[] P01I63_A46PaiCod ;
   private String[] P01I63_A312PaiNom ;
   private short[] P01I64_A46PaiCod ;
   private String[] P01I64_A312PaiNom ;
   private String[] P01I65_A1293TipoTraNom ;
   private String[] P01I65_A1292TipoTraId ;
   private String[] P01I66_A1294PaiTipoTraId ;
   private short[] P01I66_A46PaiCod ;
   private String[] P01I67_A1292TipoTraId ;
   private String[] P01I67_A1293TipoTraNom ;
   private String[] P01I68_A1292TipoTraId ;
   private String[] P01I68_A1293TipoTraNom ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class paistipotrabajoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01I62( ModelContext context ,
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

   protected Object[] conditional_P01I65( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1293TipoTraNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoTraNom" ;
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
                  return conditional_P01I62(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
            case 3 :
                  return conditional_P01I65(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01I62", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01I63", "SELECT T1.PaiTipoTraId, T1.PaiCod, T2.PaiNom FROM (PaisTipoTrabajo T1 INNER JOIN Pais T2 ON T2.PaiCod = T1.PaiCod) WHERE T1.PaiCod = ? and T1.PaiTipoTraId = ( ?) ORDER BY T1.PaiCod, T1.PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01I64", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01I65", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01I66", "SELECT PaiTipoTraId, PaiCod FROM PaisTipoTrabajo WHERE PaiCod = ? and PaiTipoTraId = ( ?) ORDER BY PaiCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01I67", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01I68", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[1], 40);
               }
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

