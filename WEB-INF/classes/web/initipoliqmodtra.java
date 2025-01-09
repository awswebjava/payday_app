package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class initipoliqmodtra extends GXProcedure
{
   public initipoliqmodtra( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( initipoliqmodtra.class ), "" );
   }

   public initipoliqmodtra( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      initipoliqmodtra.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02L02 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02L02_A3CliCod[0] ;
         A344CliNom = P02L02_A344CliNom[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV18Pgmname, "0") ;
         if ( A3CliCod > 1 )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            GXt_char1 = AV14egresoTLiqCod ;
            GXt_char2 = AV14egresoTLiqCod ;
            GXv_char3[0] = GXt_char2 ;
            new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
            initipoliqmodtra.this.GXt_char2 = GXv_char3[0] ;
            GXv_char4[0] = GXt_char1 ;
            new web.getparametro(remoteHandle, context).execute( A3CliCod, GXt_char2, GXv_char4) ;
            initipoliqmodtra.this.GXt_char1 = GXv_char4[0] ;
            AV14egresoTLiqCod = GXt_char1 ;
            GXt_char2 = AV13anticipoTLiqCod ;
            GXt_char1 = AV13anticipoTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqanticipo_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            initipoliqmodtra.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( A3CliCod, GXt_char1, GXv_char3) ;
            initipoliqmodtra.this.GXt_char2 = GXv_char3[0] ;
            AV13anticipoTLiqCod = GXt_char2 ;
            GXt_char2 = AV12variosTLiqCod ;
            GXt_char1 = AV12variosTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqvarios_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            initipoliqmodtra.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( A3CliCod, GXt_char1, GXv_char3) ;
            initipoliqmodtra.this.GXt_char2 = GXv_char3[0] ;
            AV12variosTLiqCod = GXt_char2 ;
            GXt_char2 = AV11vacTLiqCod ;
            GXt_char1 = AV11vacTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            initipoliqmodtra.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( A3CliCod, GXt_char1, GXv_char3) ;
            initipoliqmodtra.this.GXt_char2 = GXv_char3[0] ;
            AV11vacTLiqCod = GXt_char2 ;
            GXt_char2 = AV10mesTLiqCod ;
            GXt_char1 = AV10mesTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            initipoliqmodtra.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( A3CliCod, GXt_char1, GXv_char3) ;
            initipoliqmodtra.this.GXt_char2 = GXv_char3[0] ;
            AV10mesTLiqCod = GXt_char2 ;
            GXt_char2 = AV9quincenaTLiqCod ;
            GXt_char1 = AV9quincenaTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            initipoliqmodtra.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( A3CliCod, GXt_char1, GXv_char3) ;
            initipoliqmodtra.this.GXt_char2 = GXv_char3[0] ;
            AV9quincenaTLiqCod = GXt_char2 ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV18Pgmname, "1") ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV9quincenaTLiqCod, "I", (byte)(4), httpContext.getMessage( "Día", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV9quincenaTLiqCod, "I", (byte)(3), httpContext.getMessage( "Semana", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV9quincenaTLiqCod, "I", (byte)(2), httpContext.getMessage( "Primera quincena", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV9quincenaTLiqCod, "E", (byte)(2), httpContext.getMessage( "Primera quincena", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV10mesTLiqCod, "E", (byte)(1), httpContext.getMessage( "Mes", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV10mesTLiqCod, "E", (byte)(2), httpContext.getMessage( "Segunda quincena", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV10mesTLiqCod, "I", (byte)(1), httpContext.getMessage( "Mes", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV11vacTLiqCod, "E", (byte)(1), httpContext.getMessage( "Adelanto de vacaciones", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV11vacTLiqCod, "E", (byte)(2), httpContext.getMessage( "Adelanto de vacaciones", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV12variosTLiqCod, "E", (byte)(1), httpContext.getMessage( "Varios", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV12variosTLiqCod, "E", (byte)(2), httpContext.getMessage( "Varios", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV13anticipoTLiqCod, "E", (byte)(1), httpContext.getMessage( "Anticipo", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV13anticipoTLiqCod, "E", (byte)(2), httpContext.getMessage( "Anticipo", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV14egresoTLiqCod, "E", (byte)(1), httpContext.getMessage( "Egreso", "")) ;
            new web.newtipoliqmodtra(remoteHandle, context).execute( A3CliCod, AV14egresoTLiqCod, "E", (byte)(2), httpContext.getMessage( "Egreso", "")) ;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
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
      scmdbuf = "" ;
      P02L02_A3CliCod = new int[1] ;
      P02L02_A344CliNom = new String[] {""} ;
      A344CliNom = "" ;
      AV18Pgmname = "" ;
      AV14egresoTLiqCod = "" ;
      AV13anticipoTLiqCod = "" ;
      AV12variosTLiqCod = "" ;
      AV11vacTLiqCod = "" ;
      AV10mesTLiqCod = "" ;
      AV9quincenaTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.initipoliqmodtra__default(),
         new Object[] {
             new Object[] {
            P02L02_A3CliCod, P02L02_A344CliNom
            }
         }
      );
      AV18Pgmname = "iniTipoLiqModTra" ;
      /* GeneXus formulas. */
      AV18Pgmname = "iniTipoLiqModTra" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV18Pgmname ;
   private String AV14egresoTLiqCod ;
   private String AV13anticipoTLiqCod ;
   private String AV12variosTLiqCod ;
   private String AV11vacTLiqCod ;
   private String AV10mesTLiqCod ;
   private String AV9quincenaTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private boolean Cond_result ;
   private String A344CliNom ;
   private IDataStoreProvider pr_default ;
   private int[] P02L02_A3CliCod ;
   private String[] P02L02_A344CliNom ;
}

final  class initipoliqmodtra__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02L02( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[1];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CliCod, CliNom FROM Cliente" ;
      if ( ! (0==AV8CliCod) )
      {
         addWhere(sWhereString, "(CliCod = ?)");
      }
      else
      {
         GXv_int5[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P02L02(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02L02", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
      }
   }

}

