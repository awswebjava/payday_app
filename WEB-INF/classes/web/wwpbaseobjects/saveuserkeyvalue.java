package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class saveuserkeyvalue extends GXProcedure
{
   public saveuserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( saveuserkeyvalue.class ), "" );
   }

   public saveuserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( String aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String aP1 )
   {
      saveuserkeyvalue.this.AV9UserCustomKey = aP0;
      saveuserkeyvalue.this.AV10UserCustomValue = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17key = AV9UserCustomKey ;
      if ( GXutil.strcmp(AV9UserCustomKey, httpContext.getMessage( "EmpCod", "")) == 0 )
      {
         /* Execute user subroutine: 'GET CLI KEY' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(AV9UserCustomKey, httpContext.getMessage( "LiquidacionLegajoWCGridState", "")) == 0 )
      {
         /* Execute user subroutine: 'GET LIQ KEY' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(AV9UserCustomKey, httpContext.getMessage( "LiquidacionVerDetalle2GridState", "")) == 0 )
      {
         /* Execute user subroutine: 'GET LIQLEG KEY' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         /* Execute user subroutine: 'GET EMP KEY' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV8Session.setValue(AV17key, AV10UserCustomValue);
      AV11UserCustom.Load(new web.getusulogged(remoteHandle, context).executeUdp( ), AV17key);
      if ( ! AV11UserCustom.Success() )
      {
         AV11UserCustom = (web.SdtUserCustom)new web.SdtUserCustom( remoteHandle, context);
         GXt_char1 = "" ;
         GXv_char2[0] = GXt_char1 ;
         new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
         saveuserkeyvalue.this.GXt_char1 = GXv_char2[0] ;
         AV11UserCustom.setgxTv_SdtUserCustom_Userid( GXt_char1 );
         AV11UserCustom.setgxTv_SdtUserCustom_Usercustomkey( AV17key );
      }
      AV11UserCustom.setgxTv_SdtUserCustom_Usercustomvalue( AV10UserCustomValue );
      AV11UserCustom.Save();
      if ( AV11UserCustom.GetMessages().size() > 0 )
      {
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "wwpbaseobjects.saveuserkeyvalue");
      cleanup();
   }

   public void S111( )
   {
      /* 'GET LIQ KEY' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GET FROM SESSION' */
      S121 ();
      if (returnInSub) return;
      AV17key += GXutil.trim( GXutil.str( AV14CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV15EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV16LiqNro, 8, 0)) ;
   }

   public void S131( )
   {
      /* 'GET LIQLEG KEY' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GET LIQ KEY' */
      S111 ();
      if (returnInSub) return;
      AV17key += "_" + GXutil.trim( GXutil.str( AV18LegNumero, 8, 0)) ;
   }

   public void S141( )
   {
      /* 'GET EMP KEY' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GET FROM SESSION' */
      S121 ();
      if (returnInSub) return;
      AV17key += GXutil.trim( GXutil.str( AV14CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV15EmpCod, 4, 0)) ;
   }

   public void S151( )
   {
      /* 'GET CLI KEY' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GET FROM SESSION' */
      S121 ();
      if (returnInSub) return;
      AV17key += GXutil.trim( GXutil.str( AV14CliCod, 6, 0)) ;
   }

   public void S121( )
   {
      /* 'GET FROM SESSION' Routine */
      returnInSub = false ;
      AV12GridState.fromxml(AV10UserCustomValue, null, null);
      AV21GXV1 = 1 ;
      while ( AV21GXV1 <= AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV13GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV12GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV21GXV1));
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), httpContext.getMessage( "PARM_&CLICOD", "")) == 0 )
         {
            AV14CliCod = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), httpContext.getMessage( "PARM_&EMPCOD", "")) == 0 )
         {
            AV15EmpCod = (short)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), httpContext.getMessage( "PARM_&LIQNRO", "")) == 0 )
         {
            AV16LiqNro = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         if ( GXutil.strcmp(AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), httpContext.getMessage( "PARM_&LEGNUMERO", "")) == 0 )
         {
            AV18LegNumero = (int)(GXutil.lval( AV13GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         AV21GXV1 = (int)(AV21GXV1+1) ;
      }
      if ( (0==AV14CliCod) )
      {
         GXt_int3 = AV14CliCod ;
         GXv_int4[0] = GXt_int3 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
         saveuserkeyvalue.this.GXt_int3 = GXv_int4[0] ;
         AV14CliCod = GXt_int3 ;
      }
      if ( (0==AV15EmpCod) )
      {
         GXt_int5 = AV15EmpCod ;
         GXv_int6[0] = GXt_int5 ;
         new web.getempcod(remoteHandle, context).execute( GXv_int6) ;
         saveuserkeyvalue.this.GXt_int5 = GXv_int6[0] ;
         AV15EmpCod = GXt_int5 ;
      }
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17key = "" ;
      AV8Session = httpContext.getWebSession();
      AV11UserCustom = new web.SdtUserCustom(remoteHandle);
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV12GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV13GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXv_int4 = new int[1] ;
      GXv_int6 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.saveuserkeyvalue__default(),
         new Object[] {
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15EmpCod ;
   private short GXt_int5 ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV16LiqNro ;
   private int AV18LegNumero ;
   private int AV21GXV1 ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean returnInSub ;
   private String AV9UserCustomKey ;
   private String AV10UserCustomValue ;
   private String AV17key ;
   private IDataStoreProvider pr_default ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private web.SdtUserCustom AV11UserCustom ;
   private web.wwpbaseobjects.SdtWWPGridState AV12GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV13GridStateFilterValue ;
}

final  class saveuserkeyvalue__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

