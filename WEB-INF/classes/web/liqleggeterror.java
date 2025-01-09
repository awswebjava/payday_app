package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqleggeterror extends GXProcedure
{
   public liqleggeterror( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqleggeterror.class ), "" );
   }

   public liqleggeterror( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 )
   {
      liqleggeterror.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 )
   {
      liqleggeterror.this.AV8clicod = aP0;
      liqleggeterror.this.AV9empcod = aP1;
      liqleggeterror.this.AV10liqnro = aP2;
      liqleggeterror.this.AV11legnumero = aP3;
      liqleggeterror.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV8clicod, 6, 0))+httpContext.getMessage( " e,m´¿ ¿ ", "")+GXutil.str( AV9empcod, 4, 0)+httpContext.getMessage( " liq ", "")+GXutil.trim( GXutil.str( AV10liqnro, 8, 0))+httpContext.getMessage( " legnum ", "")+GXutil.trim( GXutil.str( AV11legnumero, 8, 0))) ;
      if ( (GXutil.strcmp("", AV12error)==0) )
      {
         /* Using cursor P00AX2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV10liqnro), Integer.valueOf(AV11legnumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A6LegNumero = P00AX2_A6LegNumero[0] ;
            A31LiqNro = P00AX2_A31LiqNro[0] ;
            A1EmpCod = P00AX2_A1EmpCod[0] ;
            A3CliCod = P00AX2_A3CliCod[0] ;
            A499LiqLegCntConc = P00AX2_A499LiqLegCntConc[0] ;
            A891LiqLegError = P00AX2_A891LiqLegError[0] ;
            new web.msgdebug(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "LiqLegCntConc ", "")+GXutil.trim( GXutil.str( A499LiqLegCntConc, 4, 0))) ;
            if ( ( A499LiqLegCntConc <= 0 ) && (GXutil.strcmp("", A891LiqLegError)==0) )
            {
               GXt_char1 = AV12error ;
               GXv_char2[0] = GXt_char1 ;
               new web.textoerrornohayimprimibles(remoteHandle, context).execute( AV8clicod, GXv_char2) ;
               liqleggeterror.this.GXt_char1 = GXv_char2[0] ;
               AV12error = GXt_char1 ;
               new web.msgdebug(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "asignar error", "")) ;
            }
            else
            {
               if ( ! (GXutil.strcmp("", A891LiqLegError)==0) )
               {
                  AV12error = GXutil.trim( A891LiqLegError) ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      new web.msgdebug(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&error ", "")+AV12error) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = liqleggeterror.this.AV12error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12error = "" ;
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      P00AX2_A6LegNumero = new int[1] ;
      P00AX2_A31LiqNro = new int[1] ;
      P00AX2_A1EmpCod = new short[1] ;
      P00AX2_A3CliCod = new int[1] ;
      P00AX2_A499LiqLegCntConc = new short[1] ;
      P00AX2_A891LiqLegError = new String[] {""} ;
      A891LiqLegError = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqleggeterror__default(),
         new Object[] {
             new Object[] {
            P00AX2_A6LegNumero, P00AX2_A31LiqNro, P00AX2_A1EmpCod, P00AX2_A3CliCod, P00AX2_A499LiqLegCntConc, P00AX2_A891LiqLegError
            }
         }
      );
      AV15Pgmname = "LiqLegGetError" ;
      /* GeneXus formulas. */
      AV15Pgmname = "LiqLegGetError" ;
      Gx_err = (short)(0) ;
   }

   private short AV9empcod ;
   private short A1EmpCod ;
   private short A499LiqLegCntConc ;
   private short Gx_err ;
   private int AV8clicod ;
   private int AV10liqnro ;
   private int AV11legnumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV12error ;
   private String A891LiqLegError ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P00AX2_A6LegNumero ;
   private int[] P00AX2_A31LiqNro ;
   private short[] P00AX2_A1EmpCod ;
   private int[] P00AX2_A3CliCod ;
   private short[] P00AX2_A499LiqLegCntConc ;
   private String[] P00AX2_A891LiqLegError ;
}

final  class liqleggeterror__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AX2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqLegCntConc, LiqLegError FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
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

