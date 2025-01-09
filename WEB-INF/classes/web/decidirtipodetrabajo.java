package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class decidirtipodetrabajo extends GXProcedure
{
   public decidirtipodetrabajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( decidirtipodetrabajo.class ), "" );
   }

   public decidirtipodetrabajo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( boolean aP0 ,
                             boolean aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 )
   {
      decidirtipodetrabajo.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( boolean aP0 ,
                        boolean aP1 ,
                        boolean aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( boolean aP0 ,
                             boolean aP1 ,
                             boolean aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String[] aP6 )
   {
      decidirtipodetrabajo.this.AV12diurnoEs = aP0;
      decidirtipodetrabajo.this.AV11nocturnoEs = aP1;
      decidirtipodetrabajo.this.AV8insalubreEs = aP2;
      decidirtipodetrabajo.this.AV13diurnoLegTipoTra = aP3;
      decidirtipodetrabajo.this.AV14nocturnoLegTipoTra = aP4;
      decidirtipodetrabajo.this.AV10insalubreLegTipoTra = aP5;
      decidirtipodetrabajo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&insalubreEs ", "")+GXutil.trim( GXutil.booltostr( AV8insalubreEs))) ;
      if ( AV8insalubreEs )
      {
         AV9PaiTipoTraId = AV10insalubreLegTipoTra ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&nocturnoEs ", "")+GXutil.trim( GXutil.booltostr( AV11nocturnoEs))) ;
         if ( AV11nocturnoEs )
         {
            if ( ! AV12diurnoEs )
            {
               AV9PaiTipoTraId = AV14nocturnoLegTipoTra ;
            }
            else
            {
               AV9PaiTipoTraId = AV13diurnoLegTipoTra ;
            }
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV17Pgmname, httpContext.getMessage( "&diurnoLegTipoTra ", "")+AV13diurnoLegTipoTra) ;
            AV9PaiTipoTraId = AV13diurnoLegTipoTra ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = decidirtipodetrabajo.this.AV9PaiTipoTraId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9PaiTipoTraId = "" ;
      AV17Pgmname = "" ;
      AV17Pgmname = "decidirTipoDeTrabajo" ;
      /* GeneXus formulas. */
      AV17Pgmname = "decidirTipoDeTrabajo" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV13diurnoLegTipoTra ;
   private String AV14nocturnoLegTipoTra ;
   private String AV10insalubreLegTipoTra ;
   private String AV9PaiTipoTraId ;
   private String AV17Pgmname ;
   private boolean AV12diurnoEs ;
   private boolean AV11nocturnoEs ;
   private boolean AV8insalubreEs ;
   private String[] aP6 ;
}

