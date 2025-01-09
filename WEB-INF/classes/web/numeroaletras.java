package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class numeroaletras extends GXProcedure
{
   public numeroaletras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( numeroaletras.class ), "" );
   }

   public numeroaletras( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( java.math.BigDecimal aP0 )
   {
      numeroaletras.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( java.math.BigDecimal aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( java.math.BigDecimal aP0 ,
                             String[] aP1 )
   {
      numeroaletras.this.AV8NReal = aP0;
      numeroaletras.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV22Unidad[1-1] = httpContext.getMessage( "uno ", "") ;
      AV22Unidad[2-1] = httpContext.getMessage( "dos ", "") ;
      AV22Unidad[3-1] = httpContext.getMessage( "tres ", "") ;
      AV22Unidad[4-1] = httpContext.getMessage( "cuatro ", "") ;
      AV22Unidad[5-1] = httpContext.getMessage( "cinco ", "") ;
      AV22Unidad[6-1] = httpContext.getMessage( "seis ", "") ;
      AV22Unidad[7-1] = httpContext.getMessage( "siete ", "") ;
      AV22Unidad[8-1] = httpContext.getMessage( "ocho ", "") ;
      AV22Unidad[9-1] = httpContext.getMessage( "nueve ", "") ;
      AV22Unidad[10-1] = httpContext.getMessage( "diez ", "") ;
      AV22Unidad[11-1] = httpContext.getMessage( "once ", "") ;
      AV22Unidad[12-1] = httpContext.getMessage( "doce ", "") ;
      AV22Unidad[13-1] = httpContext.getMessage( "trece ", "") ;
      AV22Unidad[14-1] = httpContext.getMessage( "catorce ", "") ;
      AV22Unidad[15-1] = httpContext.getMessage( "quince ", "") ;
      AV22Unidad[16-1] = httpContext.getMessage( "dieciseis ", "") ;
      AV22Unidad[17-1] = httpContext.getMessage( "diecisiete ", "") ;
      AV22Unidad[18-1] = httpContext.getMessage( "dieciocho ", "") ;
      AV22Unidad[19-1] = httpContext.getMessage( "diecinueve ", "") ;
      AV21Decena[1-1] = httpContext.getMessage( "diez ", "") ;
      AV21Decena[2-1] = httpContext.getMessage( "veinti ", "") ;
      AV21Decena[3-1] = httpContext.getMessage( "treinta ", "") ;
      AV21Decena[4-1] = httpContext.getMessage( "cuarenta ", "") ;
      AV21Decena[5-1] = httpContext.getMessage( "cincuenta ", "") ;
      AV21Decena[6-1] = httpContext.getMessage( "sesenta ", "") ;
      AV21Decena[7-1] = httpContext.getMessage( "setenta ", "") ;
      AV21Decena[8-1] = httpContext.getMessage( "ochenta ", "") ;
      AV21Decena[9-1] = httpContext.getMessage( "noventa ", "") ;
      AV20Centena[1-1] = httpContext.getMessage( "ciento ", "") ;
      AV20Centena[2-1] = httpContext.getMessage( "doscientos ", "") ;
      AV20Centena[3-1] = httpContext.getMessage( "trescientos ", "") ;
      AV20Centena[4-1] = httpContext.getMessage( "cuatrocientos ", "") ;
      AV20Centena[5-1] = httpContext.getMessage( "quinientos ", "") ;
      AV20Centena[6-1] = httpContext.getMessage( "seiscientos ", "") ;
      AV20Centena[7-1] = httpContext.getMessage( "setecientos ", "") ;
      AV20Centena[8-1] = httpContext.getMessage( "ochocientos ", "") ;
      AV20Centena[9-1] = httpContext.getMessage( "novecientos ", "") ;
      AV10N = (long)(GXutil.Int( DecimalUtil.decToDouble(AV8NReal))) ;
      AV11F = (byte)(DecimalUtil.decToDouble(GXutil.roundDecimal( (AV8NReal.multiply(DecimalUtil.doubleToDec(100)).subtract(DecimalUtil.doubleToDec(AV10N*100))), 2))) ;
      AV14x = (short)(1) ;
      while ( AV14x < 257 )
      {
         AV13StrAux[AV14x-1] = " " ;
         AV14x = (short)(AV14x+1) ;
      }
      AV14x = (short)(0) ;
      if ( AV10N != 0 )
      {
         if ( AV10N >= 1000000000L )
         {
            AV25TX = (long)(GXutil.Int( AV10N/ (double) (1000000000L))) ;
            AV18T = (int)(AV25TX) ;
            AV23Uni = (byte)(0) ;
            /* Execute user subroutine: 'CENTE' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV10N = (long)(AV10N-GXutil.Int( AV25TX*1000000000L)) ;
            AV15Comodin = httpContext.getMessage( "_mil_ ", "") ;
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         if ( AV10N >= 1000000 )
         {
            AV25TX = (long)(GXutil.Int( AV10N/ (double) (1000000))) ;
            AV18T = (int)(AV25TX) ;
            AV23Uni = (byte)(0) ;
            /* Execute user subroutine: 'CENTE' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV10N = (long)(AV10N-GXutil.Int( AV25TX*1000000)) ;
            if ( AV25TX == 1 )
            {
               if ( AV10N != 0 )
               {
                  AV15Comodin = httpContext.getMessage( "_millón_ ", "") ;
               }
               else
               {
                  AV15Comodin = httpContext.getMessage( "_millón ", "") ;
               }
            }
            else
            {
               if ( AV10N != 0 )
               {
                  AV15Comodin = httpContext.getMessage( "_millones_ ", "") ;
               }
               else
               {
                  AV15Comodin = httpContext.getMessage( "_millones ", "") ;
               }
            }
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         if ( AV10N >= 1000 )
         {
            AV25TX = (long)(GXutil.Int( AV10N/ (double) (1000))) ;
            AV18T = (int)(AV25TX) ;
            AV23Uni = (byte)(0) ;
            /* Execute user subroutine: 'CENTE' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV10N = (long)(AV10N-GXutil.Int( AV25TX*1000)) ;
            if ( AV10N != 0 )
            {
               AV15Comodin = httpContext.getMessage( "_mil_ ", "") ;
            }
            else
            {
               AV15Comodin = httpContext.getMessage( "_mil ", "") ;
            }
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV18T = (int)(AV10N) ;
         AV23Uni = (byte)(1) ;
         /* Execute user subroutine: 'CENTE' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'MAYUSCULA' */
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
         AV15Comodin = httpContext.getMessage( "Cero ", "") ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( AV11F != 0 )
      {
         if ( AV11F < 10 )
         {
            AV12XS = GXutil.str( AV11F, 1, 0) ;
         }
         else
         {
            AV12XS = GXutil.str( AV11F, 2, 0) ;
         }
         AV15Comodin = GXutil.concat( httpContext.getMessage( "_con_ ", ""), AV12XS, "") ;
         AV15Comodin = GXutil.concat( AV15Comodin, httpContext.getMessage( "_centavos ", ""), "") ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV15Comodin = ". " ;
      /* Execute user subroutine: 'MUEVE' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV9NumAStr = "" ;
      AV16y = (short)(1) ;
      while ( AV16y <= AV14x )
      {
         if ( GXutil.strcmp(AV13StrAux[AV16y-1], "_") == 0 )
         {
            AV13StrAux[AV16y-1] = " " ;
         }
         AV16y = (short)(AV16y+1) ;
      }
      AV16y = (short)(1) ;
      while ( AV16y <= AV14x )
      {
         if ( AV16y > 1 )
         {
            if ( AV16y > 2 )
            {
               if ( GXutil.strcmp(AV13StrAux[AV16y-1-1], " ") == 0 )
               {
                  AV9NumAStr = GXutil.concat( AV9NumAStr, AV13StrAux[AV16y-1], " ") ;
               }
               else
               {
                  AV9NumAStr = GXutil.concat( AV9NumAStr, AV13StrAux[AV16y-1], "") ;
               }
            }
            else
            {
               AV9NumAStr = GXutil.concat( AV9NumAStr, AV13StrAux[AV16y-1], "") ;
            }
         }
         else
         {
            AV9NumAStr = GXutil.concat( AV9NumAStr, AV13StrAux[AV16y-1], "") ;
         }
         AV16y = (short)(AV16y+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'MUEVE' Routine */
      returnInSub = false ;
      AV14x = (short)(AV14x+1) ;
      AV16y = (short)(1) ;
      AV17Letra = httpContext.getMessage( "L", "") ;
      while ( ( AV16y < 257 ) && ( AV14x < 257 ) && ( GXutil.strcmp(AV17Letra, " ") != 0 ) )
      {
         AV17Letra = GXutil.substring( AV15Comodin, AV16y, 1) ;
         AV13StrAux[AV14x-1] = AV17Letra ;
         AV14x = (short)(AV14x+1) ;
         AV16y = (short)(AV16y+1) ;
         AV17Letra = GXutil.substring( AV15Comodin, AV16y, 1) ;
      }
      AV14x = (short)(AV14x-1) ;
   }

   public void S121( )
   {
      /* 'CENTE' Routine */
      returnInSub = false ;
      if ( AV18T > 1000 )
      {
         Gx_msg = GXutil.str( AV18T, 11, 2) ;
         httpContext.GX_msglist.addItem(Gx_msg);
      }
      if ( AV18T > 100 )
      {
         AV19TT = (long)(GXutil.Int( AV18T/ (double) (100))) ;
         AV15Comodin = AV20Centena[(int)(AV19TT)-1] ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if (returnInSub) return;
         AV18T = (int)(AV18T-GXutil.Int( AV19TT*100)) ;
         if ( AV18T != 0 )
         {
            AV15Comodin = "_ " ;
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if (returnInSub) return;
         }
      }
      else
      {
         if ( AV18T == 100 )
         {
            AV15Comodin = httpContext.getMessage( "cien ", "") ;
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if (returnInSub) return;
            AV18T = 0 ;
         }
      }
      if ( ( AV18T >= 30 ) && ( AV18T <= 99 ) )
      {
         AV19TT = (long)(GXutil.Int( AV18T/ (double) (10))) ;
         AV15Comodin = AV21Decena[(int)(AV19TT)-1] ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if (returnInSub) return;
         AV18T = (int)(AV18T-GXutil.Int( AV19TT*10)) ;
         if ( AV18T != 0 )
         {
            AV15Comodin = httpContext.getMessage( "_y_ ", "") ;
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if (returnInSub) return;
         }
      }
      if ( ( AV18T >= 21 ) && ( AV18T <= 29 ) )
      {
         AV19TT = (long)(GXutil.Int( AV18T/ (double) (10))) ;
         AV15Comodin = AV21Decena[(int)(AV19TT)-1] ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if (returnInSub) return;
         AV18T = (int)(AV18T-GXutil.Int( AV19TT*10)) ;
      }
      if ( AV18T == 20 )
      {
         AV15Comodin = httpContext.getMessage( "veinte ", "") ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if (returnInSub) return;
         AV18T = (int)(AV18T-20) ;
      }
      if ( ( AV18T >= 10 ) && ( AV18T <= 19 ) )
      {
         AV15Comodin = AV22Unidad[AV18T-1] ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if (returnInSub) return;
         AV18T = 0 ;
      }
      if ( ( AV18T >= 2 ) && ( AV18T <= 9 ) )
      {
         AV15Comodin = AV22Unidad[AV18T-1] ;
         /* Execute user subroutine: 'MUEVE' */
         S111 ();
         if (returnInSub) return;
      }
      if ( AV18T == 1 )
      {
         if ( AV23Uni == 1 )
         {
            AV15Comodin = httpContext.getMessage( "uno ", "") ;
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if (returnInSub) return;
         }
         else
         {
            AV15Comodin = httpContext.getMessage( "un ", "") ;
            /* Execute user subroutine: 'MUEVE' */
            S111 ();
            if (returnInSub) return;
         }
      }
   }

   public void S131( )
   {
      /* 'MAYUSCULA' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "c", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "C", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "d", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "D", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "m", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "M", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "n", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "N", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "o", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "O", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "q", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "Q", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "s", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "S", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "t", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "T", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "u", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "U", "") ;
      }
      if ( GXutil.strcmp(AV13StrAux[1-1], httpContext.getMessage( "v", "")) == 0 )
      {
         AV13StrAux[1-1] = httpContext.getMessage( "V", "") ;
      }
   }

   protected void cleanup( )
   {
      this.aP1[0] = numeroaletras.this.AV9NumAStr;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9NumAStr = "" ;
      AV22Unidad = new String[19] ;
      GX_I = 1 ;
      while ( GX_I <= 19 )
      {
         AV22Unidad[GX_I-1] = "" ;
         GX_I = (int)(GX_I+1) ;
      }
      AV21Decena = new String[9] ;
      GX_I = 1 ;
      while ( GX_I <= 9 )
      {
         AV21Decena[GX_I-1] = "" ;
         GX_I = (int)(GX_I+1) ;
      }
      AV20Centena = new String[9] ;
      GX_I = 1 ;
      while ( GX_I <= 9 )
      {
         AV20Centena[GX_I-1] = "" ;
         GX_I = (int)(GX_I+1) ;
      }
      AV13StrAux = new String[256] ;
      GX_I = 1 ;
      while ( GX_I <= 256 )
      {
         AV13StrAux[GX_I-1] = "" ;
         GX_I = (int)(GX_I+1) ;
      }
      AV15Comodin = "" ;
      AV12XS = "" ;
      AV17Letra = "" ;
      Gx_msg = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11F ;
   private byte AV23Uni ;
   private short AV14x ;
   private short AV16y ;
   private short Gx_err ;
   private int AV18T ;
   private int GX_I ;
   private long AV10N ;
   private long AV25TX ;
   private long AV19TT ;
   private java.math.BigDecimal AV8NReal ;
   private String AV9NumAStr ;
   private String AV22Unidad[] ;
   private String AV21Decena[] ;
   private String AV20Centena[] ;
   private String AV13StrAux[] ;
   private String AV15Comodin ;
   private String AV12XS ;
   private String AV17Letra ;
   private String Gx_msg ;
   private boolean returnInSub ;
   private String[] aP1 ;
}

