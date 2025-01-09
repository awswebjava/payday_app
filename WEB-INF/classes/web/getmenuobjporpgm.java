package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuobjporpgm extends GXProcedure
{
   public getmenuobjporpgm( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuobjporpgm.class ), "" );
   }

   public getmenuobjporpgm( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String[] aP1 )
   {
      getmenuobjporpgm.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 ,
                             String[] aP2 )
   {
      getmenuobjporpgm.this.AV9programa = aP0;
      getmenuobjporpgm.this.aP1 = aP1;
      getmenuobjporpgm.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV14CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      getmenuobjporpgm.this.GXt_int1 = GXv_int2[0] ;
      AV14CliCod = GXt_int1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV14CliCod, AV17Pgmname, httpContext.getMessage( "programa ", "")+AV9programa) ;
      AV8length = (short)(GXutil.len( AV9programa)) ;
      AV10desde = (short)(AV8length-1) ;
      if ( GXutil.strcmp(GXutil.substring( AV9programa, AV10desde, 2), httpContext.getMessage( "WW", "")) == 0 )
      {
         AV11MenuOpcAcc = httpContext.getMessage( "WW", "") ;
         AV13cuantos = (short)(AV8length-2) ;
         AV12MenuOpcObj = GXutil.substring( AV9programa, 1, AV13cuantos) ;
      }
      else
      {
         if ( GXutil.strSearch( AV9programa, httpContext.getMessage( "_Update", ""), 1) != 0 )
         {
            AV11MenuOpcAcc = httpContext.getMessage( "UPD", "") ;
            /* Execute user subroutine: 'OBJ' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strSearch( AV9programa, httpContext.getMessage( "_Delete", ""), 1) != 0 )
         {
            AV11MenuOpcAcc = httpContext.getMessage( "DLT", "") ;
            /* Execute user subroutine: 'OBJ' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strSearch( AV9programa, httpContext.getMessage( "_Insert", ""), 1) != 0 )
         {
            AV11MenuOpcAcc = httpContext.getMessage( "INS", "") ;
            /* Execute user subroutine: 'OBJ' */
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
            AV11MenuOpcAcc = httpContext.getMessage( "WW", "") ;
            AV12MenuOpcObj = AV9programa ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV14CliCod, AV17Pgmname, httpContext.getMessage( "&MenuOpcObj ", "")+AV12MenuOpcObj) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'OBJ' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(GXutil.substring( AV9programa, 1, 2), httpContext.getMessage( "WW", "")) == 0 )
      {
         AV13cuantos = (short)(AV8length-9) ;
         AV12MenuOpcObj = GXutil.substring( AV9programa, 3, AV13cuantos) ;
      }
   }

   protected void cleanup( )
   {
      this.aP1[0] = getmenuobjporpgm.this.AV12MenuOpcObj;
      this.aP2[0] = getmenuobjporpgm.this.AV11MenuOpcAcc;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12MenuOpcObj = "" ;
      AV11MenuOpcAcc = "" ;
      GXv_int2 = new int[1] ;
      AV17Pgmname = "" ;
      AV17Pgmname = "getMenuObjPorPgm" ;
      /* GeneXus formulas. */
      AV17Pgmname = "getMenuObjPorPgm" ;
      Gx_err = (short)(0) ;
   }

   private short AV8length ;
   private short AV10desde ;
   private short AV13cuantos ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private String AV9programa ;
   private String AV12MenuOpcObj ;
   private String AV11MenuOpcAcc ;
   private String AV17Pgmname ;
   private boolean returnInSub ;
   private String[] aP2 ;
   private String[] aP1 ;
}

