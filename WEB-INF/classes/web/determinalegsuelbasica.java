package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class determinalegsuelbasica extends GXProcedure
{
   public determinalegsuelbasica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( determinalegsuelbasica.class ), "" );
   }

   public determinalegsuelbasica( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 ,
                              java.util.Date aP5 ,
                              short aP6 ,
                              String aP7 )
   {
      determinalegsuelbasica.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        short aP6 ,
                        String aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             String aP7 ,
                             boolean[] aP8 )
   {
      determinalegsuelbasica.this.AV12CliCod = aP0;
      determinalegsuelbasica.this.AV13EmpCod = aP1;
      determinalegsuelbasica.this.AV37LiqNro = aP2;
      determinalegsuelbasica.this.AV10LegNumero = aP3;
      determinalegsuelbasica.this.AV26TLiqCod = aP4;
      determinalegsuelbasica.this.AV17LegSuelFecha = aP5;
      determinalegsuelbasica.this.AV8LegSuelSec = aP6;
      determinalegsuelbasica.this.AV31trnPalabra = aP7;
      determinalegsuelbasica.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "ini &LegSuelSec ", "")+GXutil.trim( GXutil.str( AV8LegSuelSec, 4, 0))) ;
      if ( ! (0==AV8LegSuelSec) )
      {
         GXv_boolean1[0] = AV9LegSuelBasica ;
         new web.getlegsuelbasica(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, AV8LegSuelSec, AV17LegSuelFecha, GXv_boolean1) ;
         determinalegsuelbasica.this.AV9LegSuelBasica = GXv_boolean1[0] ;
      }
      else
      {
         AV19desdeFecha = localUtil.ymdtod( GXutil.year( AV17LegSuelFecha), GXutil.month( AV17LegSuelFecha), 1) ;
         AV20hastaFecha = GXutil.eomdate( AV17LegSuelFecha) ;
         AV9LegSuelBasica = true ;
         AV32accionesTodasPalabra.add(httpContext.getMessage( "LEGAJO", ""), 0);
         AV32accionesTodasPalabra.add(httpContext.getMessage( "FERIADOS", ""), 0);
         AV32accionesTodasPalabra.add(httpContext.getMessage( "NOVEDADES", ""), 0);
         AV32accionesTodasPalabra.add(httpContext.getMessage( "LICENCIAS", ""), 0);
         AV32accionesTodasPalabra.add(httpContext.getMessage( "OBLIGACIONES", ""), 0);
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&trnPalabra ", "")+AV31trnPalabra) ;
         if ( (GXutil.strcmp("", AV31trnPalabra)==0) )
         {
            AV29i = (short)(1) ;
            while ( AV29i <= AV32accionesTodasPalabra.size() )
            {
               AV30accionesPalabra.add((String)AV32accionesTodasPalabra.elementAt(-1+AV29i), 0);
               AV29i = (short)(AV29i+1) ;
            }
         }
         else
         {
            AV30accionesPalabra.add(AV31trnPalabra, 0);
            AV29i = (short)(1) ;
            while ( AV29i <= AV32accionesTodasPalabra.size() )
            {
               if ( GXutil.strcmp((String)AV32accionesTodasPalabra.elementAt(-1+AV29i), AV31trnPalabra) != 0 )
               {
                  AV30accionesPalabra.add((String)AV32accionesTodasPalabra.elementAt(-1+AV29i), 0);
               }
               AV29i = (short)(AV29i+1) ;
            }
         }
         AV29i = (short)(1) ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "&accionesPalabra ", "")+AV30accionesPalabra.toJSonString(false)) ;
         while ( AV29i <= AV30accionesPalabra.size() )
         {
            if ( GXutil.strcmp((String)AV30accionesPalabra.elementAt(-1+AV29i), httpContext.getMessage( "LEGAJO", "")) == 0 )
            {
               /* Execute user subroutine: 'REVISAR LEGAJO' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp((String)AV30accionesPalabra.elementAt(-1+AV29i), httpContext.getMessage( "FERIADOS", "")) == 0 )
            {
               /* Execute user subroutine: 'REVISAR FERIADO' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp((String)AV30accionesPalabra.elementAt(-1+AV29i), httpContext.getMessage( "NOVEDADES", "")) == 0 )
            {
               /* Execute user subroutine: 'REVISAR NOVEDADES' */
               S131 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp((String)AV30accionesPalabra.elementAt(-1+AV29i), httpContext.getMessage( "LICENCIAS", "")) == 0 )
            {
               /* Execute user subroutine: 'REVISAR LICENCIAS' */
               S141 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else if ( GXutil.strcmp((String)AV30accionesPalabra.elementAt(-1+AV29i), httpContext.getMessage( "OBLIGACIONES", "")) == 0 )
            {
               /* Execute user subroutine: 'REVISAR OBLIGACIONES' */
               S151 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            AV29i = (short)(AV29i+1) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "fin ", "")+GXutil.trim( GXutil.booltostr( AV9LegSuelBasica))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'REVISAR LEGAJO' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV11LegClase ;
      GXv_char3[0] = AV33LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, GXv_int2, GXv_char3) ;
      determinalegsuelbasica.this.AV11LegClase = GXv_int2[0] ;
      determinalegsuelbasica.this.AV33LegModTra = GXv_char3[0] ;
      GXv_boolean1[0] = AV22LegAgenReten ;
      new web.getlegagenreten(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, GXv_boolean1) ;
      determinalegsuelbasica.this.AV22LegAgenReten = GXv_boolean1[0] ;
      if ( AV22LegAgenReten )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "1") ;
         returnInSub = true;
         if (true) return;
      }
      GXv_char3[0] = AV34tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, 0, AV10LegNumero, (short)(0), "", "", GXv_char3) ;
      determinalegsuelbasica.this.AV34tipo_tarifa = GXv_char3[0] ;
      if ( GXutil.strcmp(AV34tipo_tarifa, "H") == 0 )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "2") ;
         returnInSub = true;
         if (true) return;
      }
      GXv_char3[0] = AV14ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, GXv_char3) ;
      determinalegsuelbasica.this.AV14ConveCodigo = GXv_char3[0] ;
      if ( ! (GXutil.strcmp("", AV14ConveCodigo)==0) )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "3") ;
         returnInSub = true;
         if (true) return;
      }
      GXv_char3[0] = AV15MprCod ;
      new web.getlegajomodalidad(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, GXv_char3) ;
      determinalegsuelbasica.this.AV15MprCod = GXv_char3[0] ;
      GXv_boolean1[0] = AV16MprEsParcial ;
      new web.getmodalidadparcial(remoteHandle, context).execute( AV15MprCod, GXv_boolean1) ;
      determinalegsuelbasica.this.AV16MprEsParcial = GXv_boolean1[0] ;
      if ( AV16MprEsParcial )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "4") ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'REVISAR FERIADO' Routine */
      returnInSub = false ;
      GXv_int2[0] = AV11LegClase ;
      GXv_char3[0] = AV33LegModTra ;
      new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, GXv_int2, GXv_char3) ;
      determinalegsuelbasica.this.AV11LegClase = GXv_int2[0] ;
      determinalegsuelbasica.this.AV33LegModTra = GXv_char3[0] ;
      GXv_boolean1[0] = AV25EmpLiqFer ;
      new web.getempliqfer(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV37LiqNro, AV10LegNumero, AV11LegClase, AV33LegModTra, GXv_boolean1) ;
      determinalegsuelbasica.this.AV25EmpLiqFer = GXv_boolean1[0] ;
      if ( AV25EmpLiqFer )
      {
         GXv_boolean1[0] = AV28feriadoHay ;
         GXv_boolean4[0] = false ;
         new web.hayferiadoenperiodo(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV26TLiqCod, AV10LegNumero, AV17LegSuelFecha, AV27tipo_feriado, false, GXv_boolean1, GXv_boolean4) ;
         determinalegsuelbasica.this.AV28feriadoHay = GXv_boolean1[0] ;
         if ( AV28feriadoHay )
         {
            AV9LegSuelBasica = false ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "5") ;
            returnInSub = true;
            if (true) return;
         }
      }
   }

   public void S131( )
   {
      /* 'REVISAR NOVEDADES' Routine */
      returnInSub = false ;
      GXv_boolean4[0] = AV18hay ;
      new web.haynovedadenperiodo(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, AV19desdeFecha, AV20hastaFecha, false, GXv_boolean4) ;
      determinalegsuelbasica.this.AV18hay = GXv_boolean4[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, httpContext.getMessage( "novedades hay ", "")+GXutil.trim( GXutil.booltostr( AV18hay))) ;
      if ( AV18hay )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "6") ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S141( )
   {
      /* 'REVISAR LICENCIAS' Routine */
      returnInSub = false ;
      GXv_boolean4[0] = AV18hay ;
      new web.estadelicenciaendia(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, "", AV19desdeFecha, AV20hastaFecha, AV21vaciaFecha, true, GXv_boolean4) ;
      determinalegsuelbasica.this.AV18hay = GXv_boolean4[0] ;
      if ( AV18hay )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "7") ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S151( )
   {
      /* 'REVISAR OBLIGACIONES' Routine */
      returnInSub = false ;
      GXv_boolean4[0] = AV18hay ;
      new web.tieneobligacionactiva(remoteHandle, context).execute( AV12CliCod, AV13EmpCod, AV10LegNumero, (short)(0), "", GXv_boolean4) ;
      determinalegsuelbasica.this.AV18hay = GXv_boolean4[0] ;
      if ( AV18hay )
      {
         AV9LegSuelBasica = false ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV40Pgmname, "8") ;
         returnInSub = true;
         if (true) return;
      }
   }

   protected void cleanup( )
   {
      this.aP8[0] = determinalegsuelbasica.this.AV9LegSuelBasica;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV40Pgmname = "" ;
      AV19desdeFecha = GXutil.nullDate() ;
      AV20hastaFecha = GXutil.nullDate() ;
      AV32accionesTodasPalabra = new GXSimpleCollection<String>(String.class, "internal", "");
      AV30accionesPalabra = new GXSimpleCollection<String>(String.class, "internal", "");
      AV33LegModTra = "" ;
      AV34tipo_tarifa = "" ;
      AV14ConveCodigo = "" ;
      AV15MprCod = "" ;
      GXv_int2 = new byte[1] ;
      GXv_char3 = new String[1] ;
      AV27tipo_feriado = "" ;
      GXv_boolean1 = new boolean[1] ;
      AV21vaciaFecha = GXutil.nullDate() ;
      GXv_boolean4 = new boolean[1] ;
      AV40Pgmname = "determinaLegSuelBasica" ;
      /* GeneXus formulas. */
      AV40Pgmname = "determinaLegSuelBasica" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11LegClase ;
   private byte GXv_int2[] ;
   private short AV13EmpCod ;
   private short AV8LegSuelSec ;
   private short AV29i ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV37LiqNro ;
   private int AV10LegNumero ;
   private String AV26TLiqCod ;
   private String AV31trnPalabra ;
   private String AV40Pgmname ;
   private String AV33LegModTra ;
   private String AV34tipo_tarifa ;
   private String AV14ConveCodigo ;
   private String AV15MprCod ;
   private String GXv_char3[] ;
   private String AV27tipo_feriado ;
   private java.util.Date AV17LegSuelFecha ;
   private java.util.Date AV19desdeFecha ;
   private java.util.Date AV20hastaFecha ;
   private java.util.Date AV21vaciaFecha ;
   private boolean AV9LegSuelBasica ;
   private boolean returnInSub ;
   private boolean AV22LegAgenReten ;
   private boolean AV16MprEsParcial ;
   private boolean AV25EmpLiqFer ;
   private boolean AV28feriadoHay ;
   private boolean GXv_boolean1[] ;
   private boolean AV18hay ;
   private boolean GXv_boolean4[] ;
   private boolean[] aP8 ;
   private GXSimpleCollection<String> AV32accionesTodasPalabra ;
   private GXSimpleCollection<String> AV30accionesPalabra ;
}

