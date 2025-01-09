package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class puestoloaddvcombo extends GXProcedure
{
   public puestoloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( puestoloaddvcombo.class ), "" );
   }

   public puestoloaddvcombo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 )
   {
      puestoloaddvcombo.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        int aP6 ,
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
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 )
   {
      puestoloaddvcombo.this.AV15ComboName = aP0;
      puestoloaddvcombo.this.AV16TrnMode = aP1;
      puestoloaddvcombo.this.AV17IsDynamicCall = aP2;
      puestoloaddvcombo.this.AV18CliCod = aP3;
      puestoloaddvcombo.this.AV19SecCodigo = aP4;
      puestoloaddvcombo.this.AV20PuestoCodigo = aP5;
      puestoloaddvcombo.this.AV27Cond_CliCod = aP6;
      puestoloaddvcombo.this.AV12SearchTxt = aP7;
      puestoloaddvcombo.this.aP8 = aP8;
      puestoloaddvcombo.this.aP9 = aP9;
      puestoloaddvcombo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWPuesto", GXv_boolean2) ;
      puestoloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "SecCodigo") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_SECCODIGO' */
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
      /* 'LOADCOMBOITEMS_SECCODIGO' Routine */
      returnInSub = false ;
      if ( AV17IsDynamicCall )
      {
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV12SearchTxt ,
                                              A329SecDescrip ,
                                              Integer.valueOf(AV27Cond_CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         lV12SearchTxt = GXutil.concat( GXutil.rtrim( AV12SearchTxt), "%", "") ;
         /* Using cursor P01MV2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV27Cond_CliCod), lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A329SecDescrip = P01MV2_A329SecDescrip[0] ;
            A3CliCod = P01MV2_A3CliCod[0] ;
            A13SecCodigo = P01MV2_A13SecCodigo[0] ;
            AV14Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A13SecCodigo );
            AV14Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A329SecDescrip );
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
            /* Using cursor P01MV3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod), AV19SecCodigo, AV20PuestoCodigo});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1240PuestoCodigo = P01MV3_A1240PuestoCodigo[0] ;
               A13SecCodigo = P01MV3_A13SecCodigo[0] ;
               A3CliCod = P01MV3_A3CliCod[0] ;
               A329SecDescrip = P01MV3_A329SecDescrip[0] ;
               A329SecDescrip = P01MV3_A329SecDescrip[0] ;
               AV21SelectedValue = A13SecCodigo ;
               AV22SelectedText = A329SecDescrip ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV19SecCodigo)==0) )
            {
               AV21SelectedValue = AV19SecCodigo ;
               /* Using cursor P01MV4 */
               pr_default.execute(2, new Object[] {Integer.valueOf(AV27Cond_CliCod), AV19SecCodigo});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A3CliCod = P01MV4_A3CliCod[0] ;
                  A13SecCodigo = P01MV4_A13SecCodigo[0] ;
                  A329SecDescrip = P01MV4_A329SecDescrip[0] ;
                  AV22SelectedText = A329SecDescrip ;
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
      this.aP8[0] = puestoloaddvcombo.this.AV21SelectedValue;
      this.aP9[0] = puestoloaddvcombo.this.AV22SelectedText;
      this.aP10[0] = puestoloaddvcombo.this.AV23Combo_DataJson;
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
      A329SecDescrip = "" ;
      P01MV2_A329SecDescrip = new String[] {""} ;
      P01MV2_A3CliCod = new int[1] ;
      P01MV2_A13SecCodigo = new String[] {""} ;
      A13SecCodigo = "" ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01MV3_A1240PuestoCodigo = new String[] {""} ;
      P01MV3_A13SecCodigo = new String[] {""} ;
      P01MV3_A3CliCod = new int[1] ;
      P01MV3_A329SecDescrip = new String[] {""} ;
      A1240PuestoCodigo = "" ;
      P01MV4_A3CliCod = new int[1] ;
      P01MV4_A13SecCodigo = new String[] {""} ;
      P01MV4_A329SecDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.puestoloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01MV2_A329SecDescrip, P01MV2_A3CliCod, P01MV2_A13SecCodigo
            }
            , new Object[] {
            P01MV3_A1240PuestoCodigo, P01MV3_A13SecCodigo, P01MV3_A3CliCod, P01MV3_A329SecDescrip
            }
            , new Object[] {
            P01MV4_A3CliCod, P01MV4_A13SecCodigo, P01MV4_A329SecDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV18CliCod ;
   private int AV27Cond_CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String AV19SecCodigo ;
   private String AV20PuestoCodigo ;
   private String scmdbuf ;
   private String A13SecCodigo ;
   private String A1240PuestoCodigo ;
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
   private String A329SecDescrip ;
   private String[] aP10 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MV2_A329SecDescrip ;
   private int[] P01MV2_A3CliCod ;
   private String[] P01MV2_A13SecCodigo ;
   private String[] P01MV3_A1240PuestoCodigo ;
   private String[] P01MV3_A13SecCodigo ;
   private int[] P01MV3_A3CliCod ;
   private String[] P01MV3_A329SecDescrip ;
   private int[] P01MV4_A3CliCod ;
   private String[] P01MV4_A13SecCodigo ;
   private String[] P01MV4_A329SecDescrip ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class puestoloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01MV2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV12SearchTxt ,
                                          String A329SecDescrip ,
                                          int AV27Cond_CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[2];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT SecDescrip, CliCod, SecCodigo FROM Seccion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV12SearchTxt)==0) )
      {
         addWhere(sWhereString, "(LOWER(SecDescrip) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SecDescrip" ;
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
                  return conditional_P01MV2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MV2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01MV3", "SELECT T1.PuestoCodigo, T1.SecCodigo, T1.CliCod, T2.SecDescrip FROM (Puesto T1 INNER JOIN Seccion T2 ON T2.CliCod = T1.CliCod AND T2.SecCodigo = T1.SecCodigo) WHERE T1.CliCod = ? and T1.SecCodigo = ( ?) and T1.PuestoCodigo = ( ?) ORDER BY T1.CliCod, T1.SecCodigo, T1.PuestoCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01MV4", "SELECT CliCod, SecCodigo, SecDescrip FROM Seccion WHERE CliCod = ? and SecCodigo = ( ?) ORDER BY CliCod, SecCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 40);
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

