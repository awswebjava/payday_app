package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class proximoconcodigo extends GXProcedure
{
   public proximoconcodigo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( proximoconcodigo.class ), "" );
   }

   public proximoconcodigo( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 )
   {
      proximoconcodigo.this.aP2 = new String[] {""};
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
      proximoconcodigo.this.AV8CliCod = aP0;
      proximoconcodigo.this.AV9TipoConCod = aP1;
      proximoconcodigo.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&TipoConCod ", "")+AV9TipoConCod) ;
      if ( GXutil.strcmp(AV9TipoConCod, "REM_ARG") == 0 )
      {
         GXt_char1 = AV16prefijo ;
         GXv_char2[0] = GXt_char1 ;
         new web.prefijoremu(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
         proximoconcodigo.this.GXt_char1 = GXv_char2[0] ;
         AV16prefijo = GXutil.trim( GXt_char1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "1") ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "2") ;
         if ( GXutil.strcmp(AV9TipoConCod, "NRE_ARG") == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "3") ;
            GXt_char1 = AV16prefijo ;
            GXv_char2[0] = GXt_char1 ;
            new web.prefijonoremu(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
            proximoconcodigo.this.GXt_char1 = GXv_char2[0] ;
            AV16prefijo = GXutil.trim( GXt_char1) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "4") ;
            if ( GXutil.strcmp(AV9TipoConCod, "CAL_ARG") == 0 )
            {
               GXt_char1 = AV16prefijo ;
               GXv_char2[0] = GXt_char1 ;
               new web.prefijocalculo(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
               proximoconcodigo.this.GXt_char1 = GXv_char2[0] ;
               AV16prefijo = GXutil.trim( GXt_char1) ;
            }
            else
            {
               GXt_char1 = AV16prefijo ;
               GXv_char2[0] = GXt_char1 ;
               new web.prefijodescuento(remoteHandle, context).execute( AV8CliCod, GXv_char2) ;
               proximoconcodigo.this.GXt_char1 = GXv_char2[0] ;
               AV16prefijo = GXutil.trim( GXt_char1) ;
            }
         }
      }
      AV20altoConCodigo = GXutil.trim( AV16prefijo) + "997" ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&prefijo ", "")+AV16prefijo+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " &altoConCodigo ", "")+AV20altoConCodigo) ;
      /* Using cursor P011E2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9TipoConCod, AV20altoConCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A26ConCodigo = P011E2_A26ConCodigo[0] ;
         A37TipoConCod = P011E2_A37TipoConCod[0] ;
         A3CliCod = P011E2_A3CliCod[0] ;
         AV11primeros3 = GXutil.substring( A26ConCodigo, 1, 3) ;
         AV11primeros3 = GXutil.upper( AV11primeros3) ;
         AV13cuantos = (short)(GXutil.len( A26ConCodigo)-2) ;
         AV12ultimos = GXutil.substring( A26ConCodigo, 4, AV13cuantos) ;
         GXt_boolean3 = AV19esNumero ;
         GXv_boolean4[0] = GXt_boolean3 ;
         new web.esnumero(remoteHandle, context).execute( AV12ultimos, GXv_boolean4) ;
         proximoconcodigo.this.GXt_boolean3 = GXv_boolean4[0] ;
         AV19esNumero = (boolean)((GXt_boolean3)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "ConCodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &primeros3 ", "")+AV11primeros3+httpContext.getMessage( " &prefijo ", "")+GXutil.upper( GXutil.trim( AV16prefijo))+httpContext.getMessage( " &ultimos ", "")+AV12ultimos+httpContext.getMessage( " es num ", "")+GXutil.trim( GXutil.booltostr( AV19esNumero))) ;
         if ( ( GXutil.strcmp(AV11primeros3, GXutil.upper( GXutil.trim( AV16prefijo))) == 0 ) && ( AV19esNumero ) )
         {
            AV17nro = (short)(GXutil.lval( AV12ultimos)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "exit", "")+GXutil.trim( GXutil.str( AV17nro, 4, 0))) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV17nro = (short)(AV17nro+1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "pre ", "")+GXutil.trim( AV16prefijo)+httpContext.getMessage( " num ", "")+GXutil.trim( GXutil.str( AV17nro, 4, 0))) ;
      AV15ConCodigo = GXutil.trim( AV16prefijo) + GXutil.padl( GXutil.str( AV17nro, 4, 0), (short)(3), "0") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "&ConCodigo ", "")+AV15ConCodigo) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = proximoconcodigo.this.AV15ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15ConCodigo = "" ;
      AV23Pgmname = "" ;
      AV16prefijo = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV20altoConCodigo = "" ;
      scmdbuf = "" ;
      P011E2_A26ConCodigo = new String[] {""} ;
      P011E2_A37TipoConCod = new String[] {""} ;
      P011E2_A3CliCod = new int[1] ;
      A26ConCodigo = "" ;
      A37TipoConCod = "" ;
      AV11primeros3 = "" ;
      AV12ultimos = "" ;
      GXv_boolean4 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.proximoconcodigo__default(),
         new Object[] {
             new Object[] {
            P011E2_A26ConCodigo, P011E2_A37TipoConCod, P011E2_A3CliCod
            }
         }
      );
      AV23Pgmname = "ProximoConcodigo" ;
      /* GeneXus formulas. */
      AV23Pgmname = "ProximoConcodigo" ;
      Gx_err = (short)(0) ;
   }

   private short AV13cuantos ;
   private short AV17nro ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV9TipoConCod ;
   private String AV15ConCodigo ;
   private String AV23Pgmname ;
   private String AV16prefijo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV20altoConCodigo ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String AV11primeros3 ;
   private String AV12ultimos ;
   private boolean AV19esNumero ;
   private boolean GXt_boolean3 ;
   private boolean GXv_boolean4[] ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P011E2_A26ConCodigo ;
   private String[] P011E2_A37TipoConCod ;
   private int[] P011E2_A3CliCod ;
}

final  class proximoconcodigo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P011E2", "SELECT ConCodigo, TipoConCod, CliCod FROM Concepto WHERE CliCod = ? and TipoConCod = ( ?) and ConCodigo <= ( ?) ORDER BY CliCod, TipoConCod, ConCodigo DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

