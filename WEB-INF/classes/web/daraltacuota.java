package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class daraltacuota extends GXProcedure
{
   public daraltacuota( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( daraltacuota.class ), "" );
   }

   public daraltacuota( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             String aP3 ,
                             boolean[] aP4 )
   {
      daraltacuota.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        short aP2 ,
                        String aP3 ,
                        boolean[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             short aP2 ,
                             String aP3 ,
                             boolean[] aP4 ,
                             String[] aP5 )
   {
      daraltacuota.this.AV8CliCod = aP0;
      daraltacuota.this.AV13ConFormula = aP1;
      daraltacuota.this.AV15AplIIGG = aP2;
      daraltacuota.this.AV12AplIIGGPrrtear = aP3;
      daraltacuota.this.aP4 = aP4;
      daraltacuota.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9saldoProrrateoBonosPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV8CliCod, "[cuotas_prorrateo]", false, false, GXv_char1) ;
      daraltacuota.this.AV9saldoProrrateoBonosPalabra = GXv_char1[0] ;
      AV10altaCuotas = false ;
      if ( GXutil.strSearch( GXutil.upper( AV13ConFormula), GXutil.upper( GXutil.trim( AV9saldoProrrateoBonosPalabra)), 1) != 0 )
      {
         AV10altaCuotas = true ;
         AV16altaCuotaIdOperando = "{tratamiento_exencion}" ;
      }
      else
      {
         if ( ! (0==AV15AplIIGG) )
         {
            GXv_char1[0] = AV11dedPalabra ;
            new web.codigoopeformula(remoteHandle, context).execute( AV8CliCod, "[deduccion]", true, false, GXv_char1) ;
            daraltacuota.this.AV11dedPalabra = GXv_char1[0] ;
            if ( GXutil.strSearch( GXutil.upper( AV13ConFormula), GXutil.upper( GXutil.trim( AV11dedPalabra)), 1) != 0 )
            {
               if ( GXutil.strcmp(AV12AplIIGGPrrtear, "VAR") == 0 )
               {
                  AV10altaCuotas = true ;
                  AV16altaCuotaIdOperando = "[deduccion]" ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = daraltacuota.this.AV10altaCuotas;
      this.aP5[0] = daraltacuota.this.AV16altaCuotaIdOperando;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16altaCuotaIdOperando = "" ;
      AV9saldoProrrateoBonosPalabra = "" ;
      AV11dedPalabra = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15AplIIGG ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV12AplIIGGPrrtear ;
   private String AV16altaCuotaIdOperando ;
   private String AV9saldoProrrateoBonosPalabra ;
   private String AV11dedPalabra ;
   private String GXv_char1[] ;
   private boolean AV10altaCuotas ;
   private String AV13ConFormula ;
   private String[] aP5 ;
   private boolean[] aP4 ;
}

