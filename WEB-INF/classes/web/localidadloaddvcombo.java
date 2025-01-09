package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class localidadloaddvcombo extends GXProcedure
{
   public localidadloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( localidadloaddvcombo.class ), "" );
   }

   public localidadloaddvcombo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             short aP4 ,
                             short aP5 ,
                             short aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      localidadloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        short aP4 ,
                        short aP5 ,
                        short aP6 ,
                        String aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             short aP4 ,
                             short aP5 ,
                             short aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      localidadloaddvcombo.this.AV17ComboName = aP0;
      localidadloaddvcombo.this.AV19TrnMode = aP1;
      localidadloaddvcombo.this.AV22IsDynamicCall = aP2;
      localidadloaddvcombo.this.AV25PaiCod = aP3;
      localidadloaddvcombo.this.AV26ProvCod = aP4;
      localidadloaddvcombo.this.AV27LocCod = aP5;
      localidadloaddvcombo.this.AV28Cond_PaiCod = aP6;
      localidadloaddvcombo.this.AV12SearchTxt = aP7;
      localidadloaddvcombo.this.aP8 = aP8;
      localidadloaddvcombo.this.aP9 = aP9;
      localidadloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWLocalidad", GXv_boolean2) ;
      localidadloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV17ComboName, "ProvCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PROVCOD' */
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
      /* 'LOADCOMBOITEMS_PROVCOD' Routine */
      returnInSub = false ;
      if ( AV22IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A322ProvNom ,
                                              Short.valueOf(A46PaiCod) ,
                                              Short.valueOf(AV28Cond_PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P001J2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV28Cond_PaiCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A46PaiCod = P001J2_A46PaiCod[0] ;
            A322ProvNom = P001J2_A322ProvNom[0] ;
            A47ProvCod = P001J2_A47ProvCod[0] ;
            AV15Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( GXutil.trim( GXutil.str( A47ProvCod, 4, 0)) );
            AV15Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A322ProvNom );
            AV14Combo_Data.add(AV15Combo_DataItem, 0);
            if ( AV14Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV13Combo_DataJson = AV14Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV19TrnMode, "INS") != 0 )
         {
            /* Using cursor P001J3 */
            pr_default.execute(1, new Object[] {Short.valueOf(AV25PaiCod), Short.valueOf(AV26ProvCod), Short.valueOf(AV27LocCod)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A48LocCod = P001J3_A48LocCod[0] ;
               A47ProvCod = P001J3_A47ProvCod[0] ;
               A46PaiCod = P001J3_A46PaiCod[0] ;
               A322ProvNom = P001J3_A322ProvNom[0] ;
               A322ProvNom = P001J3_A322ProvNom[0] ;
               AV16SelectedValue = ((0==A47ProvCod) ? "" : GXutil.trim( GXutil.str( A47ProvCod, 4, 0))) ;
               AV21SelectedText = A322ProvNom ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (0==AV26ProvCod) )
            {
               AV16SelectedValue = GXutil.trim( GXutil.str( AV26ProvCod, 4, 0)) ;
               /* Using cursor P001J4 */
               pr_default.execute(2, new Object[] {Short.valueOf(AV28Cond_PaiCod), Short.valueOf(AV26ProvCod)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A46PaiCod = P001J4_A46PaiCod[0] ;
                  A47ProvCod = P001J4_A47ProvCod[0] ;
                  A322ProvNom = P001J4_A322ProvNom[0] ;
                  AV21SelectedText = A322ProvNom ;
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
      this.aP8[0] = localidadloaddvcombo.this.AV16SelectedValue;
      this.aP9[0] = localidadloaddvcombo.this.AV21SelectedText;
      this.aP10[0] = localidadloaddvcombo.this.AV13Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16SelectedValue = "" ;
      AV21SelectedText = "" ;
      AV13Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A322ProvNom = "" ;
      P001J2_A46PaiCod = new short[1] ;
      P001J2_A322ProvNom = new String[] {""} ;
      P001J2_A47ProvCod = new short[1] ;
      AV15Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV14Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P001J3_A48LocCod = new short[1] ;
      P001J3_A47ProvCod = new short[1] ;
      P001J3_A46PaiCod = new short[1] ;
      P001J3_A322ProvNom = new String[] {""} ;
      P001J4_A46PaiCod = new short[1] ;
      P001J4_A47ProvCod = new short[1] ;
      P001J4_A322ProvNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.localidadloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P001J2_A46PaiCod, P001J2_A322ProvNom, P001J2_A47ProvCod
            }
            , new Object[] {
            P001J3_A48LocCod, P001J3_A47ProvCod, P001J3_A46PaiCod, P001J3_A322ProvNom
            }
            , new Object[] {
            P001J4_A46PaiCod, P001J4_A47ProvCod, P001J4_A322ProvNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV25PaiCod ;
   private short AV26ProvCod ;
   private short AV27LocCod ;
   private short AV28Cond_PaiCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short Gx_err ;
   private int AV11MaxItems ;
   private String AV19TrnMode ;
   private String scmdbuf ;
   private boolean AV22IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV13Combo_DataJson ;
   private String AV17ComboName ;
   private String AV12SearchTxt ;
   private String AV16SelectedValue ;
   private String AV21SelectedText ;
   private String lV12SearchTxt ;
   private String A322ProvNom ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private short[] P001J2_A46PaiCod ;
   private String[] P001J2_A322ProvNom ;
   private short[] P001J2_A47ProvCod ;
   private short[] P001J3_A48LocCod ;
   private short[] P001J3_A47ProvCod ;
   private short[] P001J3_A46PaiCod ;
   private String[] P001J3_A322ProvNom ;
   private short[] P001J4_A46PaiCod ;
   private short[] P001J4_A47ProvCod ;
   private String[] P001J4_A322ProvNom ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV14Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV15Combo_DataItem ;
}

final  class localidadloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001J2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A322ProvNom ,
                                          short A46PaiCod ,
                                          short AV28Cond_PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[2];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT PaiCod, ProvNom, ProvCod FROM Provincia" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(ProvNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ProvNom" ;
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
                  return conditional_P001J2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001J2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001J3", "SELECT T1.LocCod, T1.ProvCod, T1.PaiCod, T2.ProvNom FROM (Localidad T1 INNER JOIN Provincia T2 ON T2.PaiCod = T1.PaiCod AND T2.ProvCod = T1.ProvCod) WHERE T1.PaiCod = ? and T1.ProvCod = ? and T1.LocCod = ? ORDER BY T1.PaiCod, T1.ProvCod, T1.LocCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P001J4", "SELECT PaiCod, ProvCod, ProvNom FROM Provincia WHERE PaiCod = ? and ProvCod = ? ORDER BY PaiCod, ProvCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

