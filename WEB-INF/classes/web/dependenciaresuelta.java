package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dependenciaresuelta extends GXProcedure
{
   public dependenciaresuelta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dependenciaresuelta.class ), "" );
   }

   public dependenciaresuelta( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            boolean aP1 ,
                            String aP2 ,
                            byte aP3 ,
                            short aP4 ,
                            int aP5 ,
                            int aP6 ,
                            String aP7 ,
                            String aP8 )
   {
      dependenciaresuelta.this.aP9 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        boolean aP1 ,
                        String aP2 ,
                        byte aP3 ,
                        short aP4 ,
                        int aP5 ,
                        int aP6 ,
                        String aP7 ,
                        String aP8 ,
                        short[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             boolean aP1 ,
                             String aP2 ,
                             byte aP3 ,
                             short aP4 ,
                             int aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String aP8 ,
                             short[] aP9 )
   {
      dependenciaresuelta.this.AV10CliCod = aP0;
      dependenciaresuelta.this.AV8ConRecalcular = aP1;
      dependenciaresuelta.this.AV11ProcesoLiquidacion = aP2;
      dependenciaresuelta.this.AV13LiqDCalculado = aP3;
      dependenciaresuelta.this.AV14LiqDRecalculado = aP4;
      dependenciaresuelta.this.AV18recorridaLiqNro = aP5;
      dependenciaresuelta.this.AV17LiqNro = aP6;
      dependenciaresuelta.this.AV9ConCodigo = aP7;
      dependenciaresuelta.this.AV19ConceptoPar = aP8;
      dependenciaresuelta.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = (byte)(AV12dependenciaResuelta) ;
      new web.dependenciaresuelta2(remoteHandle, context).execute( AV10CliCod, AV9ConCodigo, AV11ProcesoLiquidacion, AV13LiqDCalculado, AV14LiqDRecalculado, GXv_int1) ;
      dependenciaresuelta.this.AV12dependenciaResuelta = GXv_int1[0] ;
      returnInSub = true;
      cleanup();
      if (true) return;
      if ( ! AV8ConRecalcular || ( GXutil.strcmp(AV11ProcesoLiquidacion, "Calculo") == 0 ) )
      {
         if ( ( AV18recorridaLiqNro == AV17LiqNro ) && ( AV13LiqDCalculado == 0 ) )
         {
            GXv_char2[0] = AV15formulaConceptoPar ;
            new web.getformulaconcepto(remoteHandle, context).execute( AV10CliCod, AV19ConceptoPar, GXv_char2) ;
            dependenciaresuelta.this.AV15formulaConceptoPar = GXv_char2[0] ;
            GXv_char2[0] = AV16conceptoPalabra ;
            new web.codigoopeformula(remoteHandle, context).execute( AV10CliCod, "{concepto}", false, true, GXv_char2) ;
            dependenciaresuelta.this.AV16conceptoPalabra = GXv_char2[0] ;
            if ( GXutil.strSearch( AV15formulaConceptoPar, "["+GXutil.trim( AV16conceptoPalabra)+" "+GXutil.trim( AV9ConCodigo), 1) != 0 )
            {
               GXv_char2[0] = AV20ConFormula ;
               new web.getformulaconcepto(remoteHandle, context).execute( AV10CliCod, AV9ConCodigo, GXv_char2) ;
               dependenciaresuelta.this.AV20ConFormula = GXv_char2[0] ;
               AV21anualPalabra = "acumulado" ;
               AV22demesesanterioresPalabra = "deMesesAnteriores" ;
               if ( ( GXutil.strSearch( AV20ConFormula, "["+GXutil.trim( AV16conceptoPalabra)+" "+GXutil.trim( AV19ConceptoPar)+" "+AV21anualPalabra, 1) != 0 ) || ( GXutil.strSearch( AV20ConFormula, "["+GXutil.trim( AV16conceptoPalabra)+" "+GXutil.trim( AV19ConceptoPar)+" "+AV22demesesanterioresPalabra, 1) != 0 ) )
               {
                  AV12dependenciaResuelta = (short)(1) ;
               }
               else
               {
                  AV12dependenciaResuelta = (short)(0) ;
               }
            }
            else
            {
               AV12dependenciaResuelta = (short)(0) ;
            }
         }
         else
         {
            AV12dependenciaResuelta = AV13LiqDCalculado ;
         }
      }
      else
      {
         if ( AV14LiqDRecalculado == 2 )
         {
            AV12dependenciaResuelta = (short)(1) ;
         }
         else
         {
            if ( ( AV18recorridaLiqNro == AV17LiqNro ) && ( AV14LiqDRecalculado == 0 ) )
            {
               GXv_char2[0] = AV15formulaConceptoPar ;
               new web.getformulaconcepto(remoteHandle, context).execute( AV10CliCod, AV19ConceptoPar, GXv_char2) ;
               dependenciaresuelta.this.AV15formulaConceptoPar = GXv_char2[0] ;
               GXv_char2[0] = AV16conceptoPalabra ;
               new web.codigoopeformula(remoteHandle, context).execute( AV10CliCod, "{concepto}", false, true, GXv_char2) ;
               dependenciaresuelta.this.AV16conceptoPalabra = GXv_char2[0] ;
               if ( GXutil.strSearch( AV15formulaConceptoPar, "["+GXutil.trim( AV16conceptoPalabra)+" "+GXutil.trim( AV9ConCodigo), 1) != 0 )
               {
                  GXv_char2[0] = AV20ConFormula ;
                  new web.getformulaconcepto(remoteHandle, context).execute( AV10CliCod, AV9ConCodigo, GXv_char2) ;
                  dependenciaresuelta.this.AV20ConFormula = GXv_char2[0] ;
                  AV21anualPalabra = "acumulado" ;
                  if ( GXutil.strSearch( AV20ConFormula, "["+GXutil.trim( AV16conceptoPalabra)+" "+GXutil.trim( AV19ConceptoPar)+" "+AV21anualPalabra, 1) != 0 )
                  {
                     AV12dependenciaResuelta = (short)(1) ;
                  }
                  else
                  {
                     AV12dependenciaResuelta = (short)(0) ;
                  }
               }
               else
               {
                  AV12dependenciaResuelta = (short)(0) ;
               }
            }
            else
            {
               if ( AV14LiqDRecalculado == 1 )
               {
                  AV12dependenciaResuelta = (short)(1) ;
               }
               else
               {
                  AV12dependenciaResuelta = (short)(0) ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = dependenciaresuelta.this.AV12dependenciaResuelta;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new byte[1] ;
      AV15formulaConceptoPar = "" ;
      AV16conceptoPalabra = "" ;
      AV20ConFormula = "" ;
      AV21anualPalabra = "" ;
      AV22demesesanterioresPalabra = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV14LiqDRecalculado ;
   private short AV12dependenciaResuelta ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV18recorridaLiqNro ;
   private int AV17LiqNro ;
   private String AV11ProcesoLiquidacion ;
   private String AV9ConCodigo ;
   private String AV19ConceptoPar ;
   private String AV16conceptoPalabra ;
   private String AV21anualPalabra ;
   private String AV22demesesanterioresPalabra ;
   private String GXv_char2[] ;
   private boolean AV8ConRecalcular ;
   private boolean returnInSub ;
   private String AV15formulaConceptoPar ;
   private String AV20ConFormula ;
   private short[] aP9 ;
}

