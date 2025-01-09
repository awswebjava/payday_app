package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class loaduserkeyvalue extends GXProcedure
{
   public loaduserkeyvalue( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( loaduserkeyvalue.class ), "" );
   }

   public loaduserkeyvalue( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             int aP1 ,
                             String aP2 )
   {
      loaduserkeyvalue.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        String aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             String aP2 ,
                             String[] aP3 )
   {
      loaduserkeyvalue.this.AV9UserCustomKey = aP0;
      loaduserkeyvalue.this.AV21ParmCliCod = aP1;
      loaduserkeyvalue.this.AV22parmSecUserName = aP2;
      loaduserkeyvalue.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18key = AV9UserCustomKey ;
      /* Execute user subroutine: 'CLICOD' */
      S151 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( GXutil.strcmp(AV9UserCustomKey, httpContext.getMessage( "EmpCod", "")) == 0 )
      {
         /* Execute user subroutine: 'GET KEY CLI' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(AV9UserCustomKey, httpContext.getMessage( "LiquidacionLegajoWCGridState", "")) == 0 )
      {
         /* Execute user subroutine: 'GET KEY LIQ' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else if ( GXutil.strcmp(AV9UserCustomKey, httpContext.getMessage( "LiquidacionVerDetalle2GridState", "")) == 0 )
      {
         /* Execute user subroutine: 'GET KEY LIQLEG' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      else
      {
         /* Execute user subroutine: 'GET KEY EMP' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV10UserCustomValue = AV8Session.getValue(AV18key) ;
      if ( (GXutil.strcmp("", AV10UserCustomValue)==0) )
      {
         if ( ! (GXutil.strcmp("", AV22parmSecUserName)==0) )
         {
            AV23SecUserName = AV22parmSecUserName ;
         }
         else
         {
            GXt_char1 = AV23SecUserName ;
            GXv_char2[0] = GXt_char1 ;
            new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
            loaduserkeyvalue.this.GXt_char1 = GXv_char2[0] ;
            AV23SecUserName = GXt_char1 ;
         }
         AV12UserCustom.Load(AV23SecUserName, AV18key);
         if ( AV12UserCustom.Success() )
         {
            AV10UserCustomValue = AV12UserCustom.getgxTv_SdtUserCustom_Usercustomvalue() ;
         }
         else
         {
            AV10UserCustomValue = "" ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GET KEY LIQLEG' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'GET KEY LIQ' */
      S121 ();
      if (returnInSub) return;
      GXv_char2[0] = AV14value ;
      new web.obtenerdesesion(remoteHandle, context).execute( httpContext.getMessage( "&LegNumero", ""), GXv_char2) ;
      loaduserkeyvalue.this.AV14value = GXv_char2[0] ;
      AV20LegNumero = (int)(GXutil.lval( AV14value)) ;
      AV18key += "_" + GXutil.trim( GXutil.str( AV20LegNumero, 8, 0)) ;
   }

   public void S121( )
   {
      /* 'GET KEY LIQ' Routine */
      returnInSub = false ;
      GXt_int3 = AV17EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      loaduserkeyvalue.this.GXt_int3 = GXv_int4[0] ;
      AV17EmpCod = GXt_int3 ;
      GXv_char2[0] = AV14value ;
      new web.obtenerdesesion(remoteHandle, context).execute( httpContext.getMessage( "&LiqNro", ""), GXv_char2) ;
      loaduserkeyvalue.this.AV14value = GXv_char2[0] ;
      AV15LiqNro = (int)(GXutil.lval( AV14value)) ;
      AV18key += GXutil.trim( GXutil.str( AV16CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV17EmpCod, 4, 0)) + "_" + GXutil.trim( GXutil.str( AV15LiqNro, 8, 0)) ;
   }

   public void S131( )
   {
      /* 'GET KEY EMP' Routine */
      returnInSub = false ;
      GXt_int3 = AV17EmpCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int4) ;
      loaduserkeyvalue.this.GXt_int3 = GXv_int4[0] ;
      AV17EmpCod = GXt_int3 ;
      AV18key += GXutil.trim( GXutil.str( AV16CliCod, 6, 0)) + "_" + GXutil.trim( GXutil.str( AV17EmpCod, 4, 0)) ;
   }

   public void S141( )
   {
      /* 'GET KEY CLI' Routine */
      returnInSub = false ;
      AV18key += GXutil.trim( GXutil.str( AV16CliCod, 6, 0)) ;
   }

   public void S151( )
   {
      /* 'CLICOD' Routine */
      returnInSub = false ;
      if ( ! (0==AV21ParmCliCod) )
      {
         AV16CliCod = AV21ParmCliCod ;
      }
      else
      {
         GXt_int5 = AV16CliCod ;
         GXv_int6[0] = GXt_int5 ;
         new web.getclicod(remoteHandle, context).execute( GXv_int6) ;
         loaduserkeyvalue.this.GXt_int5 = GXv_int6[0] ;
         AV16CliCod = GXt_int5 ;
      }
   }

   protected void cleanup( )
   {
      this.aP3[0] = loaduserkeyvalue.this.AV10UserCustomValue;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10UserCustomValue = "" ;
      AV18key = "" ;
      AV8Session = httpContext.getWebSession();
      AV23SecUserName = "" ;
      GXt_char1 = "" ;
      AV12UserCustom = new web.SdtUserCustom(remoteHandle);
      AV14value = "" ;
      GXv_char2 = new String[1] ;
      GXv_int4 = new short[1] ;
      GXv_int6 = new int[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV17EmpCod ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV21ParmCliCod ;
   private int AV20LegNumero ;
   private int AV15LiqNro ;
   private int AV16CliCod ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean returnInSub ;
   private String AV9UserCustomKey ;
   private String AV22parmSecUserName ;
   private String AV10UserCustomValue ;
   private String AV18key ;
   private String AV23SecUserName ;
   private String AV14value ;
   private com.genexus.webpanels.WebSession AV8Session ;
   private String[] aP3 ;
   private web.SdtUserCustom AV12UserCustom ;
}

