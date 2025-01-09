package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesossegundoplanopdf extends GXProcedure
{
   public procesossegundoplanopdf( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesossegundoplanopdf.class ), "" );
   }

   public procesossegundoplanopdf( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 )
   {
      procesossegundoplanopdf.this.AV8CliCod = aP0;
      procesossegundoplanopdf.this.AV9EmpCod = aP1;
      procesossegundoplanopdf.this.AV14LiqNro = aP2;
      procesossegundoplanopdf.this.AV13LegNumero = aP3;
      procesossegundoplanopdf.this.AV16ClientId = aP4;
      procesossegundoplanopdf.this.AV17LiqLote = aP5;
      procesossegundoplanopdf.this.AV39daemonUUID = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV32invocacionPDFMetodoPalabra ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.metodoinvocapdf_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesossegundoplanopdf.this.AV32invocacionPDFMetodoPalabra = GXv_char1[0] ;
      GXv_char1[0] = AV30LiqPDFEstado ;
      new web.getliqestpdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, GXv_char1) ;
      procesossegundoplanopdf.this.AV30LiqPDFEstado = GXv_char1[0] ;
      if ( ( GXutil.strcmp(AV30LiqPDFEstado, "Pendiente") != 0 ) && ( GXutil.strcmp(AV30LiqPDFEstado, "Error") != 0 ) )
      {
         GXv_int2[0] = AV37LiqEstado ;
         GXv_int3[0] = AV38liqLSDDepEst ;
         GXv_int4[0] = AV36LiqContrEst ;
         GXv_int5[0] = AV35liqAuxEstado ;
         GXv_char1[0] = AV30LiqPDFEstado ;
         new web.getliqestados(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, GXv_int2, GXv_int3, GXv_int4, GXv_int5, GXv_char1) ;
         procesossegundoplanopdf.this.AV37LiqEstado = GXv_int2[0] ;
         procesossegundoplanopdf.this.AV38liqLSDDepEst = GXv_int3[0] ;
         procesossegundoplanopdf.this.AV36LiqContrEst = GXv_int4[0] ;
         procesossegundoplanopdf.this.AV35liqAuxEstado = GXv_int5[0] ;
         procesossegundoplanopdf.this.AV30LiqPDFEstado = GXv_char1[0] ;
         if ( ( AV37LiqEstado == 2 ) || ( AV38liqLSDDepEst == 2 ) || ( AV36LiqContrEst == 2 ) || ( AV35liqAuxEstado == 2 ) )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "setea pend", "")) ;
            new web.setliqestpdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, "Pendiente") ;
         }
      }
      GXv_char1[0] = AV11imprimirLiqLeg ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.auto_imprimir_pdfliqleg_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
      procesossegundoplanopdf.this.AV11imprimirLiqLeg = GXv_char1[0] ;
      if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV11imprimirLiqLeg)), httpContext.getMessage( "NO", "")) != 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&imprimirLiqLeg ", "")+AV11imprimirLiqLeg) ;
         if ( ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV11imprimirLiqLeg)), httpContext.getMessage( "SOLO_HTML", "")) == 0 ) || ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV11imprimirLiqLeg)), httpContext.getMessage( "MASIVO", "")) == 0 ) )
         {
            AV15soloCrearHTML = true ;
         }
         else
         {
            AV15soloCrearHTML = false ;
         }
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "&&soloCrearHTML ", "")+GXutil.trim( GXutil.booltostr( AV15soloCrearHTML))) ;
         AV10i = (short)(1) ;
         GXt_char6 = AV20ParmValue ;
         GXt_char7 = AV20ParmValue ;
         GXv_char1[0] = GXt_char7 ;
         new web.pdf_automatico_estilo_codigoparam(remoteHandle, context).execute( GXv_char1) ;
         procesossegundoplanopdf.this.GXt_char7 = GXv_char1[0] ;
         GXv_char8[0] = GXt_char6 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char7, GXv_char8) ;
         procesossegundoplanopdf.this.GXt_char6 = GXv_char8[0] ;
         AV20ParmValue = GXt_char6 ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "&ParmValue ", "")+GXutil.trim( AV20ParmValue)+httpContext.getMessage( " legcount ", "")+GXutil.trim( GXutil.str( AV13LegNumero.size(), 9, 0))) ;
         while ( AV10i <= AV13LegNumero.size() )
         {
            GXv_int5[0] = AV37LiqEstado ;
            GXv_int4[0] = AV38liqLSDDepEst ;
            GXv_int3[0] = AV36LiqContrEst ;
            GXv_int2[0] = AV35liqAuxEstado ;
            GXv_char8[0] = AV30LiqPDFEstado ;
            new web.getliqestados(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, GXv_int5, GXv_int4, GXv_int3, GXv_int2, GXv_char8) ;
            procesossegundoplanopdf.this.AV37LiqEstado = GXv_int5[0] ;
            procesossegundoplanopdf.this.AV38liqLSDDepEst = GXv_int4[0] ;
            procesossegundoplanopdf.this.AV36LiqContrEst = GXv_int3[0] ;
            procesossegundoplanopdf.this.AV35liqAuxEstado = GXv_int2[0] ;
            procesossegundoplanopdf.this.AV30LiqPDFEstado = GXv_char8[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "cancelar pdf 1 liqestado ", "")+GXutil.str( AV37LiqEstado, 1, 0)+httpContext.getMessage( " lsd ", "")+GXutil.str( AV38liqLSDDepEst, 1, 0)+httpContext.getMessage( " contr ", "")+GXutil.str( AV36LiqContrEst, 1, 0)+httpContext.getMessage( " liqaux ", "")+GXutil.str( AV35liqAuxEstado, 1, 0)) ;
            if ( ( AV37LiqEstado == 2 ) || ( AV38liqLSDDepEst == 2 ) || ( AV36LiqContrEst == 2 ) || ( AV35liqAuxEstado == 2 ) || ( GXutil.strcmp(AV30LiqPDFEstado, "Error") == 0 ) )
            {
               AV34cancelar = true ;
               if ( GXutil.strcmp(AV30LiqPDFEstado, "Error") == 0 )
               {
                  AV18error = httpContext.getMessage( "No se terminó de generar los pdfs porque algo saliò mal en uno de los pdfs", "") ;
               }
               else
               {
                  AV18error = httpContext.getMessage( "No se terminó de generar los pdfs porque falló el cálculo de conceptos auxiliares", "") ;
               }
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "cancelar pdf 2", "")) ;
            }
            else
            {
               GXv_boolean9[0] = AV34cancelar ;
               new web.getliqcancel(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, GXv_boolean9) ;
               procesossegundoplanopdf.this.AV34cancelar = GXv_boolean9[0] ;
               if ( AV34cancelar )
               {
                  AV18error = httpContext.getMessage( "No se terminó de generar los pdfs porque La liquidación fué cancelada", "") ;
               }
            }
            if ( AV34cancelar )
            {
               /* Execute user subroutine: 'FIN LOTE' */
               S131 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if (true) break;
            }
            AV24auxLegNumero = ((Number) AV13LegNumero.elementAt(-1+AV10i)).intValue() ;
            /* Using cursor P02492 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV14LiqNro), Integer.valueOf(AV24auxLegNumero)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A891LiqLegError = P02492_A891LiqLegError[0] ;
               A6LegNumero = P02492_A6LegNumero[0] ;
               A31LiqNro = P02492_A31LiqNro[0] ;
               A1EmpCod = P02492_A1EmpCod[0] ;
               A3CliCod = P02492_A3CliCod[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "hola", "")) ;
               if ( (GXutil.strcmp("", AV18error)==0) )
               {
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "error vacio! parmvalue ", "")+AV20ParmValue) ;
                  if ( ( GXutil.strcmp(GXutil.upper( AV20ParmValue), httpContext.getMessage( "VERTICAL", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV20ParmValue), httpContext.getMessage( "AMBOS", "")) == 0 ) )
                  {
                     GXv_char8[0] = AV21urlRecibo ;
                     GXv_char1[0] = AV19auxError ;
                     new web.armaurlrecibopdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, AV24auxLegNumero, "Vertical", AV15soloCrearHTML, true, GXv_char8, GXv_char1) ;
                     procesossegundoplanopdf.this.AV21urlRecibo = GXv_char8[0] ;
                     procesossegundoplanopdf.this.AV19auxError = GXv_char1[0] ;
                     /* Execute user subroutine: 'AGREGA ERROR' */
                     S121 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     if ( ( GXutil.strcmp(AV32invocacionPDFMetodoPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV11imprimirLiqLeg)), httpContext.getMessage( "MASIVO", "")) == 0 ) )
                     {
                        AV25tipoRecibo = "Vertical" ;
                        /* Execute user subroutine: 'AGREGA LINK' */
                        S111 ();
                        if ( returnInSub )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
                  if ( ( GXutil.strcmp(GXutil.upper( AV20ParmValue), httpContext.getMessage( "APAISADO", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV20ParmValue), httpContext.getMessage( "AMBOS", "")) == 0 ) )
                  {
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "llama &auxLegNumero ", "")+GXutil.trim( GXutil.str( AV24auxLegNumero, 8, 0))) ;
                     GXv_char8[0] = AV21urlRecibo ;
                     GXv_char1[0] = AV19auxError ;
                     new web.armaurlrecibopdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, AV24auxLegNumero, "Apaisado", AV15soloCrearHTML, true, GXv_char8, GXv_char1) ;
                     procesossegundoplanopdf.this.AV21urlRecibo = GXv_char8[0] ;
                     procesossegundoplanopdf.this.AV19auxError = GXv_char1[0] ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "trae ", "")+AV21urlRecibo) ;
                     /* Execute user subroutine: 'AGREGA ERROR' */
                     S121 ();
                     if ( returnInSub )
                     {
                        pr_default.close(0);
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     if ( ( GXutil.strcmp(AV32invocacionPDFMetodoPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV11imprimirLiqLeg)), httpContext.getMessage( "MASIVO", "")) == 0 ) )
                     {
                        AV25tipoRecibo = "Apaisado" ;
                        /* Execute user subroutine: 'AGREGA LINK' */
                        S111 ();
                        if ( returnInSub )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
               }
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(0);
            AV10i = (short)(AV10i+1) ;
         }
      }
      GXt_char7 = AV40liqPDFModoPalabra ;
      GXt_char6 = AV40liqPDFModoPalabra ;
      GXv_char8[0] = GXt_char6 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_pdf", GXv_char8) ;
      procesossegundoplanopdf.this.GXt_char6 = GXv_char8[0] ;
      GXv_char1[0] = GXt_char7 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char6, GXv_char1) ;
      procesossegundoplanopdf.this.GXt_char7 = GXv_char1[0] ;
      AV40liqPDFModoPalabra = GXt_char7 ;
      if ( ( GXutil.strcmp(AV32invocacionPDFMetodoPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 ) && ( GXutil.strcmp(AV40liqPDFModoPalabra, httpContext.getMessage( "DAEMON", "")) != 0 ) )
      {
         AV33palabra = "3" ;
         /* Execute user subroutine: 'FIN LOTE' */
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
         if ( ! (GXutil.strcmp("", AV18error)==0) )
         {
            AV33palabra = "4" ;
            /* Execute user subroutine: 'FIN LOTE' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "volvio 5", "")) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'AGREGA LINK' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV11imprimirLiqLeg)), httpContext.getMessage( "MASIVO", "")) == 0 )
      {
         if ( ! (GXutil.strcmp("", AV21urlRecibo)==0) )
         {
            GXt_char7 = AV26htmlNombre ;
            GXv_char8[0] = GXt_char7 ;
            new web.nombrearchivorecibo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, AV24auxLegNumero, AV25tipoRecibo, httpContext.getMessage( "html", ""), "", GXv_char8) ;
            procesossegundoplanopdf.this.GXt_char7 = GXv_char8[0] ;
            AV26htmlNombre = GXt_char7 ;
            AV22s3Links.add(GXutil.trim( AV21urlRecibo)+GXutil.trim( AV26htmlNombre), 0);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "-> urlrecibo ", "")+AV21urlRecibo+httpContext.getMessage( " + &htmlNombre ", "")+AV26htmlNombre) ;
            AV23nombresPDFs.add(new web.nombrearchivorecibo(remoteHandle, context).executeUdp( AV8CliCod, AV9EmpCod, AV14LiqNro, AV24auxLegNumero, AV25tipoRecibo, httpContext.getMessage( "pdf", ""), ""), 0);
            AV27s3Paths.add(new web.getnombrecarpetaennode(remoteHandle, context).executeUdp( AV8CliCod, AV9EmpCod, AV24auxLegNumero), 0);
         }
      }
   }

   public void S121( )
   {
      /* 'AGREGA ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV19auxError)==0) )
      {
         if ( (GXutil.strcmp("", AV18error)==0) )
         {
            AV18error = GXutil.trim( AV19auxError) ;
         }
         else
         {
            AV18error += ". " + GXutil.trim( AV19auxError) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "agrega error ", "")+AV18error) ;
   }

   public void S131( )
   {
      /* 'FIN LOTE' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV18error)==0) )
      {
         AV18error += " (" + GXutil.trim( AV43Pgmname) + " " + GXutil.trim( AV33palabra) + ")" ;
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV43Pgmname, httpContext.getMessage( "cancelar pdf 3", "")) ;
      new web.finlotepdf(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV14LiqNro, AV17LiqLote, AV13LegNumero, AV25tipoRecibo, AV18error, AV11imprimirLiqLeg, AV39daemonUUID) ;
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
      AV32invocacionPDFMetodoPalabra = "" ;
      AV30LiqPDFEstado = "" ;
      AV43Pgmname = "" ;
      AV11imprimirLiqLeg = "" ;
      AV20ParmValue = "" ;
      GXv_int5 = new byte[1] ;
      GXv_int4 = new byte[1] ;
      GXv_int3 = new byte[1] ;
      GXv_int2 = new byte[1] ;
      AV18error = "" ;
      GXv_boolean9 = new boolean[1] ;
      scmdbuf = "" ;
      P02492_A891LiqLegError = new String[] {""} ;
      P02492_A6LegNumero = new int[1] ;
      P02492_A31LiqNro = new int[1] ;
      P02492_A1EmpCod = new short[1] ;
      P02492_A3CliCod = new int[1] ;
      A891LiqLegError = "" ;
      AV21urlRecibo = "" ;
      AV19auxError = "" ;
      AV25tipoRecibo = "" ;
      AV40liqPDFModoPalabra = "" ;
      GXt_char6 = "" ;
      GXv_char1 = new String[1] ;
      AV33palabra = "" ;
      AV26htmlNombre = "" ;
      GXt_char7 = "" ;
      GXv_char8 = new String[1] ;
      AV22s3Links = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23nombresPDFs = new GXSimpleCollection<String>(String.class, "internal", "");
      AV27s3Paths = new GXSimpleCollection<String>(String.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.procesossegundoplanopdf__default(),
         new Object[] {
             new Object[] {
            P02492_A891LiqLegError, P02492_A6LegNumero, P02492_A31LiqNro, P02492_A1EmpCod, P02492_A3CliCod
            }
         }
      );
      AV43Pgmname = "procesosSegundoPlanoPDF" ;
      /* GeneXus formulas. */
      AV43Pgmname = "procesosSegundoPlanoPDF" ;
      Gx_err = (short)(0) ;
   }

   private byte AV37LiqEstado ;
   private byte AV38liqLSDDepEst ;
   private byte AV36LiqContrEst ;
   private byte AV35liqAuxEstado ;
   private byte GXv_int5[] ;
   private byte GXv_int4[] ;
   private byte GXv_int3[] ;
   private byte GXv_int2[] ;
   private short AV9EmpCod ;
   private short AV10i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV14LiqNro ;
   private int AV24auxLegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV39daemonUUID ;
   private String AV32invocacionPDFMetodoPalabra ;
   private String AV30LiqPDFEstado ;
   private String AV43Pgmname ;
   private String AV11imprimirLiqLeg ;
   private String scmdbuf ;
   private String AV25tipoRecibo ;
   private String AV40liqPDFModoPalabra ;
   private String GXt_char6 ;
   private String GXv_char1[] ;
   private String AV33palabra ;
   private String GXt_char7 ;
   private String GXv_char8[] ;
   private boolean AV15soloCrearHTML ;
   private boolean AV34cancelar ;
   private boolean GXv_boolean9[] ;
   private boolean returnInSub ;
   private String AV20ParmValue ;
   private String AV16ClientId ;
   private String AV17LiqLote ;
   private String AV18error ;
   private String A891LiqLegError ;
   private String AV21urlRecibo ;
   private String AV19auxError ;
   private String AV26htmlNombre ;
   private GXSimpleCollection<Integer> AV13LegNumero ;
   private IDataStoreProvider pr_default ;
   private String[] P02492_A891LiqLegError ;
   private int[] P02492_A6LegNumero ;
   private int[] P02492_A31LiqNro ;
   private short[] P02492_A1EmpCod ;
   private int[] P02492_A3CliCod ;
   private GXSimpleCollection<String> AV22s3Links ;
   private GXSimpleCollection<String> AV23nombresPDFs ;
   private GXSimpleCollection<String> AV27s3Paths ;
}

final  class procesossegundoplanopdf__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02492", "SELECT LiqLegError, LegNumero, LiqNro, EmpCod, CliCod FROM LiquidacionLegajo WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND ((char_length(trim(trailing ' ' from LiqLegError))=0)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

