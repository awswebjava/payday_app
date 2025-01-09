package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresa_tiposdetrabajoloaddvcombo extends GXProcedure
{
   public empresa_tiposdetrabajoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresa_tiposdetrabajoloaddvcombo.class ), "" );
   }

   public empresa_tiposdetrabajoloaddvcombo( int remoteHandle ,
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
                             String[] aP7 ,
                             String[] aP8 )
   {
      empresa_tiposdetrabajoloaddvcombo.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        short aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             short aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      empresa_tiposdetrabajoloaddvcombo.this.AV15ComboName = aP0;
      empresa_tiposdetrabajoloaddvcombo.this.AV16TrnMode = aP1;
      empresa_tiposdetrabajoloaddvcombo.this.AV17IsDynamicCall = aP2;
      empresa_tiposdetrabajoloaddvcombo.this.AV18CliCod = aP3;
      empresa_tiposdetrabajoloaddvcombo.this.AV19EmpCod = aP4;
      empresa_tiposdetrabajoloaddvcombo.this.AV20PaiTipoTraId = aP5;
      empresa_tiposdetrabajoloaddvcombo.this.AV12SearchTxt = aP6;
      empresa_tiposdetrabajoloaddvcombo.this.aP7 = aP7;
      empresa_tiposdetrabajoloaddvcombo.this.aP8 = aP8;
      empresa_tiposdetrabajoloaddvcombo.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWempresa_tiposdetrabajo", GXv_boolean2) ;
      empresa_tiposdetrabajoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "PaiTipoTraId") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_PAITIPOTRAID' */
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
      /* 'LOADCOMBOITEMS_PAITIPOTRAID' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A1293TipoTraNom } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01R72 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1293TipoTraNom = P01R72_A1293TipoTraNom[0] ;
            A1292TipoTraId = P01R72_A1292TipoTraId[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A1292TipoTraId );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A1293TipoTraNom );
            AV13Combo_Data.add(AV14Combo_DataItem, 0);
            if ( AV13Combo_Data.size() > AV11MaxItems )
            {
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         AV23Combo_DataJson = AV13Combo_Data.toJSonString(false) ;
      }
      else
      {
         if ( GXutil.strcmp(AV16TrnMode, "INS") != 0 )
         {
            /* Using cursor P01R73 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV19EmpCod), AV20PaiTipoTraId});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1294PaiTipoTraId = P01R73_A1294PaiTipoTraId[0] ;
               A1EmpCod = P01R73_A1EmpCod[0] ;
               A3CliCod = P01R73_A3CliCod[0] ;
               AV21SelectedValue = A1294PaiTipoTraId ;
               AV27TipoTraId = A1294PaiTipoTraId ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
            /* Using cursor P01R74 */
            pr_default.execute(2, new Object[] {AV27TipoTraId});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1292TipoTraId = P01R74_A1292TipoTraId[0] ;
               A1293TipoTraNom = P01R74_A1293TipoTraNom[0] ;
               AV22SelectedText = A1293TipoTraNom ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(2);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV20PaiTipoTraId)==0) )
            {
               AV21SelectedValue = AV20PaiTipoTraId ;
               /* Using cursor P01R75 */
               pr_default.execute(3, new Object[] {AV20PaiTipoTraId});
               while ( (pr_default.getStatus(3) != 101) )
               {
                  A1292TipoTraId = P01R75_A1292TipoTraId[0] ;
                  A1293TipoTraNom = P01R75_A1293TipoTraNom[0] ;
                  AV22SelectedText = A1293TipoTraNom ;
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(3);
            }
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = empresa_tiposdetrabajoloaddvcombo.this.AV21SelectedValue;
      this.aP8[0] = empresa_tiposdetrabajoloaddvcombo.this.AV22SelectedText;
      this.aP9[0] = empresa_tiposdetrabajoloaddvcombo.this.AV23Combo_DataJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21SelectedValue = "" ;
      AV22SelectedText = "" ;
      AV23Combo_DataJson = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      scmdbuf = "" ;
      lV12SearchTxt = "" ;
      A1293TipoTraNom = "" ;
      P01R72_A1293TipoTraNom = new String[] {""} ;
      P01R72_A1292TipoTraId = new String[] {""} ;
      A1292TipoTraId = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01R73_A1294PaiTipoTraId = new String[] {""} ;
      P01R73_A1EmpCod = new short[1] ;
      P01R73_A3CliCod = new int[1] ;
      A1294PaiTipoTraId = "" ;
      AV27TipoTraId = "" ;
      P01R74_A1292TipoTraId = new String[] {""} ;
      P01R74_A1293TipoTraNom = new String[] {""} ;
      P01R75_A1292TipoTraId = new String[] {""} ;
      P01R75_A1293TipoTraNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresa_tiposdetrabajoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01R72_A1293TipoTraNom, P01R72_A1292TipoTraId
            }
            , new Object[] {
            P01R73_A1294PaiTipoTraId, P01R73_A1EmpCod, P01R73_A3CliCod
            }
            , new Object[] {
            P01R74_A1292TipoTraId, P01R74_A1293TipoTraNom
            }
            , new Object[] {
            P01R75_A1292TipoTraId, P01R75_A1293TipoTraNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV19EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV20PaiTipoTraId ;
   private String scmdbuf ;
   private String A1292TipoTraId ;
   private String A1294PaiTipoTraId ;
   private String AV27TipoTraId ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private String AV23Combo_DataJson ;
   private String AV15ComboName ;
   private String AV12SearchTxt ;
   private String AV21SelectedValue ;
   private String AV22SelectedText ;
   private String lV12SearchTxt ;
   private String A1293TipoTraNom ;
   private String[] aP9 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private IDataStoreProvider pr_default ;
   private String[] P01R72_A1293TipoTraNom ;
   private String[] P01R72_A1292TipoTraId ;
   private String[] P01R73_A1294PaiTipoTraId ;
   private short[] P01R73_A1EmpCod ;
   private int[] P01R73_A3CliCod ;
   private String[] P01R74_A1292TipoTraId ;
   private String[] P01R74_A1293TipoTraNom ;
   private String[] P01R75_A1292TipoTraId ;
   private String[] P01R75_A1293TipoTraNom ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class empresa_tiposdetrabajoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01R72( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A1293TipoTraNom )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT TipoTraNom, TipoTraId FROM TipoTrabajo" ;
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(TipoTraNom) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY TipoTraNom" ;
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
                  return conditional_P01R72(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01R72", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01R73", "SELECT PaiTipoTraId, EmpCod, CliCod FROM Empresatipo_trabajo WHERE CliCod = ? and EmpCod = ? and PaiTipoTraId = ( ?) ORDER BY CliCod, EmpCod, PaiTipoTraId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01R74", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01R75", "SELECT TipoTraId, TipoTraNom FROM TipoTrabajo WHERE TipoTraId = ( ?) ORDER BY TipoTraId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

