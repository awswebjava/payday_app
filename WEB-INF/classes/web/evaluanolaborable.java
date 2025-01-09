package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class evaluanolaborable extends GXProcedure
{
   public evaluanolaborable( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( evaluanolaborable.class ), "" );
   }

   public evaluanolaborable( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              byte aP4 ,
                              String aP5 ,
                              String aP6 ,
                              boolean aP7 ,
                              String aP8 ,
                              String aP9 ,
                              boolean aP10 ,
                              String aP11 ,
                              String aP12 ,
                              boolean aP13 )
   {
      evaluanolaborable.this.aP14 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        String aP12 ,
                        boolean aP13 ,
                        boolean[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             boolean[] aP14 )
   {
      evaluanolaborable.this.AV19CliCod = aP0;
      evaluanolaborable.this.AV20EmpCod = aP1;
      evaluanolaborable.this.AV21LegNumero = aP2;
      evaluanolaborable.this.AV22FerFecha = aP3;
      evaluanolaborable.this.AV18LegClase = aP4;
      evaluanolaborable.this.AV9FerReligId = aP5;
      evaluanolaborable.this.AV12LegReligion = aP6;
      evaluanolaborable.this.AV13empresaliquidaReligion = aP7;
      evaluanolaborable.this.AV10FerOrigId = aP8;
      evaluanolaborable.this.AV17LegOrigen = aP9;
      evaluanolaborable.this.AV14empresaliquidaOrigen = aP10;
      evaluanolaborable.this.AV11FeriadoConvenio = aP11;
      evaluanolaborable.this.AV16LegConveCodigo = aP12;
      evaluanolaborable.this.AV15empresaliquidaConvenio = aP13;
      evaluanolaborable.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8liquida = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "&FerReligId ", "")+AV9FerReligId+httpContext.getMessage( " &FerOrigId ", "")+AV10FerOrigId+httpContext.getMessage( " &FeriadoConvenio ", "")+AV11FeriadoConvenio+httpContext.getMessage( " &empresaliquidaReligion ", "")+GXutil.trim( GXutil.booltostr( AV13empresaliquidaReligion))) ;
      if ( (GXutil.strcmp("", AV9FerReligId)==0) && (GXutil.strcmp("", AV10FerOrigId)==0) && (GXutil.strcmp("", AV11FeriadoConvenio)==0) )
      {
         AV8liquida = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, httpContext.getMessage( "siliquida", "")) ;
      }
      else
      {
         if ( ( GXutil.strcmp(AV9FerReligId, AV12LegReligion) == 0 ) && ( AV13empresaliquidaReligion ) )
         {
            AV8liquida = true ;
         }
         else
         {
            if ( ( GXutil.strcmp(AV10FerOrigId, AV17LegOrigen) == 0 ) && ( AV14empresaliquidaOrigen ) )
            {
               AV8liquida = true ;
            }
            else
            {
               if ( ( GXutil.strcmp(AV11FeriadoConvenio, AV16LegConveCodigo) == 0 ) && ( AV15empresaliquidaConvenio ) )
               {
                  AV8liquida = true ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP14[0] = evaluanolaborable.this.AV8liquida;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26Pgmname = "" ;
      AV26Pgmname = "evaluaNoLaborable" ;
      /* GeneXus formulas. */
      AV26Pgmname = "evaluaNoLaborable" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18LegClase ;
   private short AV20EmpCod ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV21LegNumero ;
   private String AV9FerReligId ;
   private String AV12LegReligion ;
   private String AV10FerOrigId ;
   private String AV17LegOrigen ;
   private String AV11FeriadoConvenio ;
   private String AV16LegConveCodigo ;
   private String AV26Pgmname ;
   private java.util.Date AV22FerFecha ;
   private boolean AV13empresaliquidaReligion ;
   private boolean AV14empresaliquidaOrigen ;
   private boolean AV15empresaliquidaConvenio ;
   private boolean AV8liquida ;
   private boolean[] aP14 ;
}

