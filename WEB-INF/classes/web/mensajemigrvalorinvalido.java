package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mensajemigrvalorinvalido extends GXProcedure
{
   public mensajemigrvalorinvalido( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mensajemigrvalorinvalido.class ), "" );
   }

   public mensajemigrvalorinvalido( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             short aP3 )
   {
      mensajemigrvalorinvalido.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        short aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             short aP3 ,
                             String[] aP4 )
   {
      mensajemigrvalorinvalido.this.AV11CliCod = aP0;
      mensajemigrvalorinvalido.this.AV10palabra = aP1;
      mensajemigrvalorinvalido.this.AV9Descrip = aP2;
      mensajemigrvalorinvalido.this.AV18informarValores = aP3;
      mensajemigrvalorinvalido.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = httpContext.getMessage( "Valor inválido \"<i>", "") + GXutil.trim( AV9Descrip) + httpContext.getMessage( "</i>\" para ", "") + GXutil.trim( AV10palabra) + "." ;
      if ( ( AV18informarValores == ( 1 )) )
      {
         AV8texto += httpContext.getMessage( "Valores admitidos: <b>", "") ;
         if ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Relación laboral", "")) == 0 )
         {
            AV8texto += httpContext.getMessage( "Empleado, Independiente", "") ;
         }
         else if ( ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Discapacidad", "")) == 0 ) || ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "SCVO", "")) == 0 ) || ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Tiene Conyuge", "")) == 0 ) || ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Adherente", "")) == 0 ) || ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Discapacitado", "")) == 0 ) )
         {
            AV8texto += httpContext.getMessage( "SI, NO", "") ;
         }
         else if ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Género", "")) == 0 )
         {
            AV8texto += httpContext.getMessage( "Femenino, Masculino", "") ;
         }
         else if ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Frecuencia de pago", "")) == 0 )
         {
            AV22GXV2 = 1 ;
            AV21GXV1 = web.gxdomainclaseleg.getValues() ;
            while ( AV22GXV2 <= AV21GXV1.size() )
            {
               AV12ClaseLeg = ((Number) AV21GXV1.elementAt(-1+AV22GXV2)).byteValue() ;
               AV8texto += GXutil.trim( httpContext.getMessage( web.gxdomainclaseleg.getDescription(httpContext,(byte)AV12ClaseLeg), "")) + ", " ;
               AV22GXV2 = (int)(AV22GXV2+1) ;
            }
         }
         else if ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Tipo Cuenta Banco", "")) == 0 )
         {
            AV24GXV4 = 1 ;
            AV23GXV3 = web.gxdomaintipocuentabanco.getValues() ;
            while ( AV24GXV4 <= AV23GXV3.size() )
            {
               AV15tipoCuentaBanco = (String)AV23GXV3.elementAt(-1+AV24GXV4) ;
               AV8texto += GXutil.trim( httpContext.getMessage( web.gxdomaintipocuentabanco.getDescription(httpContext,(String)AV15tipoCuentaBanco), "")) + ", " ;
               AV24GXV4 = (int)(AV24GXV4+1) ;
            }
         }
         else if ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Forma de Pago", "")) == 0 )
         {
            AV26GXV6 = 1 ;
            AV25GXV5 = web.gxdomainformadepago.getValues() ;
            while ( AV26GXV6 <= AV25GXV5.size() )
            {
               AV16FormaDePago = ((Number) AV25GXV5.elementAt(-1+AV26GXV6)).byteValue() ;
               AV8texto += GXutil.trim( httpContext.getMessage( web.gxdomainformadepago.getDescription(httpContext,(byte)AV16FormaDePago), "")) + ", " ;
               AV26GXV6 = (int)(AV26GXV6+1) ;
            }
         }
         else if ( GXutil.strcmp(AV10palabra, httpContext.getMessage( "Estado Civil", "")) == 0 )
         {
            AV28GXV8 = 1 ;
            AV27GXV7 = web.gxdomainestadocivil.getValues() ;
            while ( AV28GXV8 <= AV27GXV7.size() )
            {
               AV17EstadoCivil = (String)AV27GXV7.elementAt(-1+AV28GXV8) ;
               AV8texto += GXutil.trim( httpContext.getMessage( web.gxdomainestadocivil.getDescription(httpContext,(String)AV17EstadoCivil), "")) + ", " ;
               AV28GXV8 = (int)(AV28GXV8+1) ;
            }
         }
         if ( GXutil.strSearch( AV8texto, ",", 1) != 0 )
         {
            AV14cuantos = (short)(GXutil.len( AV8texto)-1) ;
            AV8texto = GXutil.substring( AV8texto, 1, AV14cuantos) ;
         }
         AV8texto += httpContext.getMessage( "</b>", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = mensajemigrvalorinvalido.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      AV21GXV1 = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV23GXV3 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15tipoCuentaBanco = "" ;
      AV25GXV5 = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV27GXV7 = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17EstadoCivil = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12ClaseLeg ;
   private byte AV16FormaDePago ;
   private short AV18informarValores ;
   private short AV14cuantos ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV22GXV2 ;
   private int AV24GXV4 ;
   private int AV26GXV6 ;
   private int AV28GXV8 ;
   private String AV10palabra ;
   private String AV15tipoCuentaBanco ;
   private String AV17EstadoCivil ;
   private String AV9Descrip ;
   private String AV8texto ;
   private GXSimpleCollection<Byte> AV21GXV1 ;
   private GXSimpleCollection<Byte> AV25GXV5 ;
   private String[] aP4 ;
   private GXSimpleCollection<String> AV23GXV3 ;
   private GXSimpleCollection<String> AV27GXV7 ;
}

