package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsiguienteconcod extends GXProcedure
{
   public getsiguienteconcod( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsiguienteconcod.class ), "" );
   }

   public getsiguienteconcod( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      getsiguienteconcod.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getsiguienteconcod.this.AV8CliCod = aP0;
      getsiguienteconcod.this.AV9TipoConCod = aP1;
      getsiguienteconcod.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00S72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9TipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P00S72_A26ConCodigo[0] ;
         A37TipoConCod = P00S72_A37TipoConCod[0] ;
         A3CliCod = P00S72_A3CliCod[0] ;
         if ( ( GXutil.strcmp(AV9TipoConCod, "NRE_ARG") != 0 ) || ( ( GXutil.strcmp(A26ConCodigo, httpContext.getMessage( "NRE998", "")) < 0 ) ) )
         {
            AV10ConCodigo = A26ConCodigo ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( GXutil.strcmp(AV9TipoConCod, "REM_ARG") == 0 )
      {
         GXt_char1 = AV12prefijoPalabra ;
         GXv_char2[0] = GXt_char1 ;
         new web.prefijoremu(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
         getsiguienteconcod.this.GXt_char1 = GXv_char2[0] ;
         AV12prefijoPalabra = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV9TipoConCod, "NRE_ARG") == 0 )
      {
         GXt_char1 = AV12prefijoPalabra ;
         GXv_char2[0] = GXt_char1 ;
         new web.prefijonoremu(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
         getsiguienteconcod.this.GXt_char1 = GXv_char2[0] ;
         AV12prefijoPalabra = GXt_char1 ;
      }
      else if ( GXutil.strcmp(AV9TipoConCod, "DES_ARG") == 0 )
      {
         GXt_char1 = AV12prefijoPalabra ;
         GXv_char2[0] = GXt_char1 ;
         new web.prefijodescuento(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
         getsiguienteconcod.this.GXt_char1 = GXv_char2[0] ;
         AV12prefijoPalabra = GXt_char1 ;
      }
      AV11auxPalabra = GXutil.strReplace( AV10ConCodigo, GXutil.trim( AV12prefijoPalabra), "") ;
      AV13auxNumero = (short)(GXutil.lval( AV11auxPalabra)) ;
      AV14siguienteNro = (short)(AV13auxNumero+1) ;
      AV10ConCodigo = GXutil.trim( AV12prefijoPalabra) + GXutil.padl( GXutil.trim( GXutil.str( AV14siguienteNro, 4, 0)), (short)(3), "0") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsiguienteconcod.this.AV10ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConCodigo = "" ;
      scmdbuf = "" ;
      P00S72_A26ConCodigo = new String[] {""} ;
      P00S72_A37TipoConCod = new String[] {""} ;
      P00S72_A3CliCod = new int[1] ;
      A26ConCodigo = "" ;
      A37TipoConCod = "" ;
      AV12prefijoPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV11auxPalabra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsiguienteconcod__default(),
         new Object[] {
             new Object[] {
            P00S72_A26ConCodigo, P00S72_A37TipoConCod, P00S72_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV13auxNumero ;
   private short AV14siguienteNro ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9TipoConCod ;
   private String AV10ConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String AV12prefijoPalabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV11auxPalabra ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00S72_A26ConCodigo ;
   private String[] P00S72_A37TipoConCod ;
   private int[] P00S72_A3CliCod ;
}

final  class getsiguienteconcod__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00S72", "SELECT ConCodigo, TipoConCod, CliCod FROM Concepto WHERE CliCod = ? and TipoConCod = ( ?) ORDER BY CliCod, TipoConCod, ConCodigo DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

