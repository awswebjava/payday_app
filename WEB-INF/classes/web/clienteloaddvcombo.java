package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteloaddvcombo extends GXProcedure
{
   public clienteloaddvcombo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteloaddvcombo.class ), "" );
   }

   public clienteloaddvcombo( int remoteHandle ,
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
                             String[] aP5 ,
                             String[] aP6 )
   {
      clienteloaddvcombo.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        int aP3 ,
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
                             int aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      clienteloaddvcombo.this.AV15ComboName = aP0;
      clienteloaddvcombo.this.AV16TrnMode = aP1;
      clienteloaddvcombo.this.AV17IsDynamicCall = aP2;
      clienteloaddvcombo.this.AV18CliCod = aP3;
      clienteloaddvcombo.this.AV12SearchTxt = aP4;
      clienteloaddvcombo.this.aP5 = aP5;
      clienteloaddvcombo.this.aP6 = aP6;
      clienteloaddvcombo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCliente", GXv_boolean2) ;
      clienteloaddvcombo.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV9WWPContext = GXv_SdtWWPContext3[0] ;
         AV11MaxItems = 100 ;
         if ( GXutil.strcmp(AV15ComboName, "CliPaiCod") == 0 )
         {
            /* Execute user subroutine: 'LOADCOMBOITEMS_CLIPAICOD' */
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
      /* 'LOADCOMBOITEMS_CLIPAICOD' Routine */
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
         /* Using cursor P01I12 */
         pr_default.execute(0, new Object[] {lV12SearchTxt});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A312PaiNom = P01I12_A312PaiNom[0] ;
            A46PaiCod = P01I12_A46PaiCod[0] ;
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
               /* Using cursor P01I13 */
               pr_default.execute(1, new Object[] {Integer.valueOf(AV18CliCod)});
               while ( (pr_default.getStatus(1) != 101) )
               {
                  A3CliCod = P01I13_A3CliCod[0] ;
                  A4CliPaiCod = P01I13_A4CliPaiCod[0] ;
                  n4CliPaiCod = P01I13_n4CliPaiCod[0] ;
                  AV19SelectedValue = ((0==A4CliPaiCod) ? "" : GXutil.trim( GXutil.str( A4CliPaiCod, 4, 0))) ;
                  AV25PaiCod = A4CliPaiCod ;
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(1);
            }
            else
            {
               AV25PaiCod = (short)(GXutil.lval( AV12SearchTxt)) ;
            }
            /* Using cursor P01I14 */
            pr_default.execute(2, new Object[] {Short.valueOf(AV25PaiCod)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A46PaiCod = P01I14_A46PaiCod[0] ;
               A312PaiNom = P01I14_A312PaiNom[0] ;
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
      this.aP5[0] = clienteloaddvcombo.this.AV19SelectedValue;
      this.aP6[0] = clienteloaddvcombo.this.AV20SelectedText;
      this.aP7[0] = clienteloaddvcombo.this.AV21Combo_DataJson;
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
      P01I12_A312PaiNom = new String[] {""} ;
      P01I12_A46PaiCod = new short[1] ;
      AV14Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      AV13Combo_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      P01I13_A3CliCod = new int[1] ;
      P01I13_A4CliPaiCod = new short[1] ;
      P01I13_n4CliPaiCod = new boolean[] {false} ;
      P01I14_A46PaiCod = new short[1] ;
      P01I14_A312PaiNom = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteloaddvcombo__default(),
         new Object[] {
             new Object[] {
            P01I12_A312PaiNom, P01I12_A46PaiCod
            }
            , new Object[] {
            P01I13_A3CliCod, P01I13_A4CliPaiCod, P01I13_n4CliPaiCod
            }
            , new Object[] {
            P01I14_A46PaiCod, P01I14_A312PaiNom
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A46PaiCod ;
   private short A4CliPaiCod ;
   private short AV25PaiCod ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int AV11MaxItems ;
   private int A3CliCod ;
   private String AV16TrnMode ;
   private String scmdbuf ;
   private boolean AV17IsDynamicCall ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n4CliPaiCod ;
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
   private String[] P01I12_A312PaiNom ;
   private short[] P01I12_A46PaiCod ;
   private int[] P01I13_A3CliCod ;
   private short[] P01I13_A4CliPaiCod ;
   private boolean[] P01I13_n4CliPaiCod ;
   private short[] P01I14_A46PaiCod ;
   private String[] P01I14_A312PaiNom ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV13Combo_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV14Combo_DataItem ;
}

final  class clienteloaddvcombo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01I12( ModelContext context ,
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
                  return conditional_P01I12(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01I12", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01I13", "SELECT CliCod, CliPaiCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01I14", "SELECT PaiCod, PaiNom FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

