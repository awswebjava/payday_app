package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabatipoliqaux extends GXProcedure
{
   public grabatipoliqaux( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabatipoliqaux.class ), "" );
   }

   public grabatipoliqaux( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String aP1 )
   {
      grabatipoliqaux.this.AV8clicod = aP0;
      grabatipoliqaux.this.AV9concodigo = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV11vacacionesTLiqCod ;
      GXt_char2 = AV11vacacionesTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char2, GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      AV11vacacionesTLiqCod = GXt_char1 ;
      GXt_char2 = AV24variosTLiqCod ;
      GXt_char1 = AV24variosTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char1, GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      AV24variosTLiqCod = GXt_char2 ;
      GXt_char2 = AV12aguinaldoTLiqCod ;
      GXt_char1 = AV12aguinaldoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char1, GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      AV12aguinaldoTLiqCod = GXt_char2 ;
      GXt_char2 = AV13egresoTLiqCod ;
      GXt_char1 = AV13egresoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char1, GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      AV13egresoTLiqCod = GXt_char2 ;
      GXt_char2 = AV14mesTLiqCod ;
      GXt_char1 = AV14mesTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char1, GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      AV14mesTLiqCod = GXt_char2 ;
      GXt_char2 = AV15quincenaTLiqCod ;
      GXt_char1 = AV15quincenaTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char1, GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      AV15quincenaTLiqCod = GXt_char2 ;
      GXt_char2 = AV25anticipoTLiqCod ;
      GXt_char1 = AV25anticipoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqanticipo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      grabatipoliqaux.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8clicod, GXt_char1, GXv_char3) ;
      grabatipoliqaux.this.GXt_char2 = GXv_char3[0] ;
      AV25anticipoTLiqCod = GXt_char2 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV8clicod, 6, 0))+httpContext.getMessage( " &concodigo ", "")+GXutil.trim( AV9concodigo)) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV9concodigo ,
                                           A26ConCodigo ,
                                           Integer.valueOf(AV8clicod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P00112 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), AV9concodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A39SubTipoConCod2 = P00112_A39SubTipoConCod2[0] ;
         n39SubTipoConCod2 = P00112_n39SubTipoConCod2[0] ;
         A26ConCodigo = P00112_A26ConCodigo[0] ;
         A3CliCod = P00112_A3CliCod[0] ;
         A372SubTipoConDes2 = P00112_A372SubTipoConDes2[0] ;
         A371SubTipoConDes1 = P00112_A371SubTipoConDes1[0] ;
         A970ConClasifAux = P00112_A970ConClasifAux[0] ;
         n970ConClasifAux = P00112_n970ConClasifAux[0] ;
         A37TipoConCod = P00112_A37TipoConCod[0] ;
         A38SubTipoConCod1 = P00112_A38SubTipoConCod1[0] ;
         n38SubTipoConCod1 = P00112_n38SubTipoConCod1[0] ;
         A41ConDescrip = P00112_A41ConDescrip[0] ;
         A503ConTipoLiqAux = P00112_A503ConTipoLiqAux[0] ;
         n503ConTipoLiqAux = P00112_n503ConTipoLiqAux[0] ;
         A371SubTipoConDes1 = P00112_A371SubTipoConDes1[0] ;
         A372SubTipoConDes2 = P00112_A372SubTipoConDes2[0] ;
         if ( GXutil.strcmp(GXutil.trim( GXutil.upper( A371SubTipoConDes1)), GXutil.trim( GXutil.upper( A372SubTipoConDes2))) == 0 )
         {
            A970ConClasifAux = GXutil.trim( A371SubTipoConDes1) ;
            n970ConClasifAux = false ;
         }
         else
         {
            AV18palabras = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(A372SubTipoConDes2," ")) ;
            if ( AV18palabras.size() >= 1 )
            {
               AV17primeraPalabra = (String)AV18palabras.elementAt(-1+1) ;
            }
            else
            {
               AV17primeraPalabra = GXutil.trim( A372SubTipoConDes2) ;
            }
            AV19cuantos = (short)(GXutil.len( GXutil.trim( AV17primeraPalabra))-1) ;
            AV17primeraPalabra = GXutil.substring( AV17primeraPalabra, 1, AV19cuantos) ;
            GXv_char4[0] = AV23primeraPalabraSinAcentos ;
            new web.sacaracentos2(remoteHandle, context).execute( AV17primeraPalabra, GXv_char4) ;
            grabatipoliqaux.this.AV23primeraPalabraSinAcentos = GXv_char4[0] ;
            AV17primeraPalabra = GXutil.trim( AV23primeraPalabraSinAcentos) ;
            if ( ! (GXutil.strcmp("", A372SubTipoConDes2)==0) && ( GXutil.strSearch( GXutil.upper( A371SubTipoConDes1), GXutil.trim( GXutil.upper( AV17primeraPalabra)), 1) != 0 ) )
            {
               A970ConClasifAux = GXutil.trim( A372SubTipoConDes2) ;
               n970ConClasifAux = false ;
            }
            else
            {
               AV21TipoConCod = A37TipoConCod ;
               AV22SubTipoConCod1 = A38SubTipoConCod1 ;
               /* Execute user subroutine: 'CANTIDAD SUB2' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  pr_default.close(0);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " ConDescrip.ToUpper() ", "")+GXutil.upper( A41ConDescrip)+httpContext.getMessage( " &primeraPalabra.ToUpper() ", "")+GXutil.upper( AV17primeraPalabra)) ;
               if ( ( ( AV20cantidadSub2 <= 1 ) || ( GXutil.strcmp(GXutil.upper( GXutil.trim( A372SubTipoConDes2)), httpContext.getMessage( "OTROS", "")) == 0 ) ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( A372SubTipoConDes2)), httpContext.getMessage( "DEPENDENCIA", "")) != 0 ) )
               {
                  A970ConClasifAux = GXutil.trim( A371SubTipoConDes1) ;
                  n970ConClasifAux = false ;
               }
               else
               {
                  if ( GXutil.strSearch( GXutil.upper( A372SubTipoConDes2), httpContext.getMessage( "DEDUCCIONES", ""), 1) != 0 )
                  {
                     A970ConClasifAux = GXutil.trim( A372SubTipoConDes2) ;
                     n970ConClasifAux = false ;
                  }
                  else
                  {
                     if ( ( GXutil.strcmp(GXutil.upper( GXutil.trim( A371SubTipoConDes1)), httpContext.getMessage( "BÁSICO", "")) == 0 ) && ( GXutil.strcmp(GXutil.upper( GXutil.trim( A372SubTipoConDes2)), httpContext.getMessage( "SUELDO", "")) == 0 ) )
                     {
                        A970ConClasifAux = httpContext.getMessage( "Sueldo Básico", "") ;
                        n970ConClasifAux = false ;
                     }
                     else
                     {
                        if ( GXutil.strcmp(GXutil.upper( GXutil.trim( A371SubTipoConDes1)), httpContext.getMessage( "BENEFICIOS SOCIALES", "")) == 0 )
                        {
                           A970ConClasifAux = httpContext.getMessage( "Beneficio/Indemnización", "") ;
                           n970ConClasifAux = false ;
                        }
                        else
                        {
                           A970ConClasifAux = GXutil.trim( A371SubTipoConDes1) ;
                           n970ConClasifAux = false ;
                           if ( ! (GXutil.strcmp("", A372SubTipoConDes2)==0) )
                           {
                              A970ConClasifAux += "/" + GXutil.trim( A372SubTipoConDes2) ;
                              n970ConClasifAux = false ;
                           }
                        }
                     }
                  }
               }
            }
         }
         AV10ConTipoLiqAux = "" ;
         AV26auxConCodigo = A26ConCodigo ;
         /* Execute user subroutine: 'TIPOS DE LIQUIDACION' */
         S131 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            pr_default.close(0);
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         A503ConTipoLiqAux = AV10ConTipoLiqAux ;
         n503ConTipoLiqAux = false ;
         AV16ConConveAux = "" ;
         /* Using cursor P00113 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(n970ConClasifAux), A970ConClasifAux, Boolean.valueOf(n503ConTipoLiqAux), A503ConTipoLiqAux, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'AGREGAR COMA' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV10ConTipoLiqAux)==0) )
      {
         AV10ConTipoLiqAux += ", " ;
      }
   }

   public void S121( )
   {
      /* 'CANTIDAD SUB2' Routine */
      returnInSub = false ;
      GXv_int5[0] = AV20cantidadSub2 ;
      new web.cantidadsub2(remoteHandle, context).execute( AV21TipoConCod, AV22SubTipoConCod1, GXv_int5) ;
      grabatipoliqaux.this.AV20cantidadSub2 = GXv_int5[0] ;
   }

   public void S131( )
   {
      /* 'TIPOS DE LIQUIDACION' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV8clicod, 6, 0))+httpContext.getMessage( " &auxConCodigo ", "")+GXutil.trim( AV26auxConCodigo)) ;
      AV27cant = (short)(0) ;
      AV33GXLvl99 = (byte)(0) ;
      /* Using cursor P00114 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV8clicod), AV26auxConCodigo});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A26ConCodigo = P00114_A26ConCodigo[0] ;
         A3CliCod = P00114_A3CliCod[0] ;
         A32TLiqCod = P00114_A32TLiqCod[0] ;
         AV33GXLvl99 = (byte)(1) ;
         AV27cant = (short)(AV27cant+1) ;
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV12aguinaldoTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "SAC", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "SAC", "") ;
         }
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV13egresoTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "Egreso", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "Egreso", "") ;
         }
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV14mesTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "Mensual", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "Mensual", "") ;
         }
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV15quincenaTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "Quincena", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "Quincena", "") ;
         }
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV11vacacionesTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "Vac.", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "Vac.", "") ;
         }
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV25anticipoTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "Anticipo", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "Anticipo", "") ;
         }
         if ( ( GXutil.strcmp(GXutil.trim( A32TLiqCod), GXutil.trim( AV24variosTLiqCod)) == 0 ) && ( GXutil.strSearch( AV10ConTipoLiqAux, httpContext.getMessage( "Varios", ""), 1) == 0 ) )
         {
            /* Execute user subroutine: 'AGREGAR COMA' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               returnInSub = true;
               if (true) return;
            }
            AV10ConTipoLiqAux += httpContext.getMessage( "Varios", "") ;
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV33GXLvl99 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "none", "")) ;
         AV10ConTipoLiqAux = httpContext.getMessage( "Ninguno", "") ;
      }
      GXt_int6 = AV28cantTodos ;
      GXv_int5[0] = GXt_int6 ;
      new web.cantidadtiposliq(remoteHandle, context).execute( AV8clicod, GXv_int5) ;
      grabatipoliqaux.this.GXt_int6 = GXv_int5[0] ;
      AV28cantTodos = GXt_int6 ;
      if ( AV27cant >= AV28cantTodos )
      {
         AV10ConTipoLiqAux = httpContext.getMessage( "Todos", "") ;
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
      AV11vacacionesTLiqCod = "" ;
      AV24variosTLiqCod = "" ;
      AV12aguinaldoTLiqCod = "" ;
      AV13egresoTLiqCod = "" ;
      AV14mesTLiqCod = "" ;
      AV15quincenaTLiqCod = "" ;
      AV25anticipoTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV31Pgmname = "" ;
      scmdbuf = "" ;
      A26ConCodigo = "" ;
      P00112_A39SubTipoConCod2 = new String[] {""} ;
      P00112_n39SubTipoConCod2 = new boolean[] {false} ;
      P00112_A26ConCodigo = new String[] {""} ;
      P00112_A3CliCod = new int[1] ;
      P00112_A372SubTipoConDes2 = new String[] {""} ;
      P00112_A371SubTipoConDes1 = new String[] {""} ;
      P00112_A970ConClasifAux = new String[] {""} ;
      P00112_n970ConClasifAux = new boolean[] {false} ;
      P00112_A37TipoConCod = new String[] {""} ;
      P00112_A38SubTipoConCod1 = new String[] {""} ;
      P00112_n38SubTipoConCod1 = new boolean[] {false} ;
      P00112_A41ConDescrip = new String[] {""} ;
      P00112_A503ConTipoLiqAux = new String[] {""} ;
      P00112_n503ConTipoLiqAux = new boolean[] {false} ;
      A39SubTipoConCod2 = "" ;
      A372SubTipoConDes2 = "" ;
      A371SubTipoConDes1 = "" ;
      A970ConClasifAux = "" ;
      A37TipoConCod = "" ;
      A38SubTipoConCod1 = "" ;
      A41ConDescrip = "" ;
      A503ConTipoLiqAux = "" ;
      AV18palabras = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17primeraPalabra = "" ;
      AV23primeraPalabraSinAcentos = "" ;
      GXv_char4 = new String[1] ;
      AV21TipoConCod = "" ;
      AV22SubTipoConCod1 = "" ;
      AV10ConTipoLiqAux = "" ;
      AV26auxConCodigo = "" ;
      AV16ConConveAux = "" ;
      A32TLiqCod = "" ;
      P00114_A26ConCodigo = new String[] {""} ;
      P00114_A3CliCod = new int[1] ;
      P00114_A32TLiqCod = new String[] {""} ;
      GXv_int5 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabatipoliqaux__default(),
         new Object[] {
             new Object[] {
            P00112_A39SubTipoConCod2, P00112_n39SubTipoConCod2, P00112_A26ConCodigo, P00112_A3CliCod, P00112_A372SubTipoConDes2, P00112_A371SubTipoConDes1, P00112_A970ConClasifAux, P00112_n970ConClasifAux, P00112_A37TipoConCod, P00112_A38SubTipoConCod1,
            P00112_n38SubTipoConCod1, P00112_A41ConDescrip, P00112_A503ConTipoLiqAux, P00112_n503ConTipoLiqAux
            }
            , new Object[] {
            }
            , new Object[] {
            P00114_A26ConCodigo, P00114_A3CliCod, P00114_A32TLiqCod
            }
         }
      );
      AV31Pgmname = "grabaTipoLiqAux" ;
      /* GeneXus formulas. */
      AV31Pgmname = "grabaTipoLiqAux" ;
      Gx_err = (short)(0) ;
   }

   private byte AV33GXLvl99 ;
   private short AV19cuantos ;
   private short AV20cantidadSub2 ;
   private short AV27cant ;
   private short AV28cantTodos ;
   private short GXt_int6 ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV8clicod ;
   private int A3CliCod ;
   private String AV9concodigo ;
   private String AV11vacacionesTLiqCod ;
   private String AV24variosTLiqCod ;
   private String AV12aguinaldoTLiqCod ;
   private String AV13egresoTLiqCod ;
   private String AV14mesTLiqCod ;
   private String AV15quincenaTLiqCod ;
   private String AV25anticipoTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV31Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A39SubTipoConCod2 ;
   private String A37TipoConCod ;
   private String A38SubTipoConCod1 ;
   private String AV17primeraPalabra ;
   private String AV23primeraPalabraSinAcentos ;
   private String GXv_char4[] ;
   private String AV21TipoConCod ;
   private String AV22SubTipoConCod1 ;
   private String AV26auxConCodigo ;
   private String A32TLiqCod ;
   private boolean n39SubTipoConCod2 ;
   private boolean n970ConClasifAux ;
   private boolean n38SubTipoConCod1 ;
   private boolean n503ConTipoLiqAux ;
   private boolean returnInSub ;
   private String A372SubTipoConDes2 ;
   private String A371SubTipoConDes1 ;
   private String A970ConClasifAux ;
   private String A41ConDescrip ;
   private String A503ConTipoLiqAux ;
   private String AV10ConTipoLiqAux ;
   private String AV16ConConveAux ;
   private IDataStoreProvider pr_default ;
   private String[] P00112_A39SubTipoConCod2 ;
   private boolean[] P00112_n39SubTipoConCod2 ;
   private String[] P00112_A26ConCodigo ;
   private int[] P00112_A3CliCod ;
   private String[] P00112_A372SubTipoConDes2 ;
   private String[] P00112_A371SubTipoConDes1 ;
   private String[] P00112_A970ConClasifAux ;
   private boolean[] P00112_n970ConClasifAux ;
   private String[] P00112_A37TipoConCod ;
   private String[] P00112_A38SubTipoConCod1 ;
   private boolean[] P00112_n38SubTipoConCod1 ;
   private String[] P00112_A41ConDescrip ;
   private String[] P00112_A503ConTipoLiqAux ;
   private boolean[] P00112_n503ConTipoLiqAux ;
   private String[] P00114_A26ConCodigo ;
   private int[] P00114_A3CliCod ;
   private String[] P00114_A32TLiqCod ;
   private GXSimpleCollection<String> AV18palabras ;
}

final  class grabatipoliqaux__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00112( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV9concodigo ,
                                          String A26ConCodigo ,
                                          int AV8clicod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[2];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.SubTipoConCod2, T1.ConCodigo, T1.CliCod, T3.SubTipoConDes2, T2.SubTipoConDes1, T1.ConClasifAux, T1.TipoConCod, T1.SubTipoConCod1, T1.ConDescrip, T1.ConTipoLiqAux" ;
      scmdbuf += " FROM ((Concepto T1 LEFT JOIN TipoDeConceptoSubtipo1 T2 ON T2.TipoConCod = T1.TipoConCod AND T2.SubTipoConCod1 = T1.SubTipoConCod1) LEFT JOIN tipo_concepto_subtipo2" ;
      scmdbuf += " T3 ON T3.TipoConCod = T1.TipoConCod AND T3.SubTipoConCod1 = T1.SubTipoConCod1 AND T3.SubTipoConCod2 = T1.SubTipoConCod2)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV9concodigo)==0) )
      {
         addWhere(sWhereString, "(T1.ConCodigo = ( ?))");
      }
      else
      {
         GXv_int7[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod" ;
      scmdbuf += " FOR UPDATE OF T1, T1, T1" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P00112(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00112", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00113", "SAVEPOINT gxupdate;UPDATE Concepto SET ConClasifAux=?, ConTipoLiqAux=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00114", "SELECT ConCodigo, CliCod, TLiqCod FROM ConceptoTipoLiquidacion WHERE CliCod = ? and ConCodigo = ( ?) ORDER BY CliCod, ConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getVarchar(4);
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getString(7, 20);
               ((String[]) buf[9])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(9);
               ((String[]) buf[12])[0] = rslt.getVarchar(10);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 10);
               }
               return;
            case 1 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(1, (String)parms[1], 80);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 40);
               }
               stmt.setInt(3, ((Number) parms[4]).intValue());
               stmt.setString(4, (String)parms[5], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
      }
   }

}

