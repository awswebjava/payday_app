package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validarcondicionesdesculey extends GXProcedure
{
   public validarcondicionesdesculey( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validarcondicionesdesculey.class ), "" );
   }

   public validarcondicionesdesculey( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            String aP1 ,
                            boolean aP2 ,
                            boolean aP3 ,
                            String aP4 ,
                            String[] aP5 )
   {
      validarcondicionesdesculey.this.aP6 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean aP3 ,
                        String aP4 ,
                        String[] aP5 ,
                        short[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean aP3 ,
                             String aP4 ,
                             String[] aP5 ,
                             short[] aP6 )
   {
      validarcondicionesdesculey.this.AV8CliCod = aP0;
      validarcondicionesdesculey.this.AV9ConCodigo = aP1;
      validarcondicionesdesculey.this.AV13parmLegLiqApo = aP2;
      validarcondicionesdesculey.this.AV15parmLegJubilado = aP3;
      validarcondicionesdesculey.this.AV16parmSinCod = aP4;
      validarcondicionesdesculey.this.aP5 = aP5;
      validarcondicionesdesculey.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10ConCondicion ;
      GXv_char2[0] = AV11ConCondCodigo ;
      new web.getconceptocondicion(remoteHandle, context).execute( AV8CliCod, AV9ConCodigo, GXv_char1, GXv_char2) ;
      validarcondicionesdesculey.this.AV10ConCondicion = GXv_char1[0] ;
      validarcondicionesdesculey.this.AV11ConCondCodigo = GXv_char2[0] ;
      AV12entra = (short)((byte)((true)?1:0)) ;
      if ( GXutil.strcmp(AV10ConCondicion, "A3") == 0 )
      {
         if ( ! AV13parmLegLiqApo )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV12entra = (short)((byte)((false)?1:0)) ;
            AV14validarLiqDLog = httpContext.getMessage( "Trabajador no aplica a liquidación de aportes", "") ;
         }
         else
         {
            if ( AV15parmLegJubilado )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV14validarLiqDLog = httpContext.getMessage( "Trabajador es jubilado", "") ;
               AV12entra = (short)((byte)((false)?1:0)) ;
            }
            else
            {
               AV14validarLiqDLog = httpContext.getMessage( "Trabajador no es jubiliado y aplica a liquidación de aportes", "") ;
            }
         }
      }
      else if ( GXutil.strcmp(AV10ConCondicion, "LA") == 0 )
      {
         if ( ! AV13parmLegLiqApo )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV12entra = (short)((byte)((false)?1:0)) ;
            AV14validarLiqDLog = httpContext.getMessage( "Trabajador no aplica a liquidación de aportes", "") ;
         }
         else
         {
            AV14validarLiqDLog = httpContext.getMessage( "Trabajador aplica a liquidación de aportes", "") ;
         }
      }
      else if ( GXutil.strcmp(AV10ConCondicion, "A10") == 0 )
      {
         if ( (GXutil.strcmp("", AV16parmSinCod)==0) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV12entra = (short)((byte)((false)?1:0)) ;
            AV14validarLiqDLog = httpContext.getMessage( "Trabajador no tiene sindicato", "") ;
         }
         else
         {
            AV14validarLiqDLog = httpContext.getMessage( "Trabajador tiene sindicato", "") ;
         }
      }
      else
      {
         AV12entra = (short)((byte)((false)?1:0)) ;
         AV14validarLiqDLog = httpContext.getMessage( "No se calcula condición ", "") + GXutil.trim( httpContext.getMessage( web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV10ConCondicion), "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = validarcondicionesdesculey.this.AV14validarLiqDLog;
      this.aP6[0] = validarcondicionesdesculey.this.AV12entra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14validarLiqDLog = "" ;
      AV10ConCondicion = "" ;
      GXv_char1 = new String[1] ;
      AV11ConCondCodigo = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12entra ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV9ConCodigo ;
   private String AV16parmSinCod ;
   private String AV10ConCondicion ;
   private String GXv_char1[] ;
   private String AV11ConCondCodigo ;
   private String GXv_char2[] ;
   private boolean AV13parmLegLiqApo ;
   private boolean AV15parmLegJubilado ;
   private boolean Cond_result ;
   private String AV14validarLiqDLog ;
   private short[] aP6 ;
   private String[] aP5 ;
}

