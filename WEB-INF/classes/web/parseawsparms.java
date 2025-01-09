package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parseawsparms extends GXProcedure
{
   public parseawsparms( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parseawsparms.class ), "" );
   }

   public parseawsparms( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             GXSimpleCollection<String>[] aP1 )
   {
      parseawsparms.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        GXSimpleCollection<String>[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             GXSimpleCollection<String>[] aP1 ,
                             String[] aP2 )
   {
      parseawsparms.this.AV10RawData = aP0;
      parseawsparms.this.aP1 = aP1;
      parseawsparms.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      System.out.println( httpContext.getMessage( "Recibí ", "")+GXutil.trim( AV10RawData) );
      if ( GXutil.strSearch( AV10RawData, httpContext.getMessage( "eventSourceArn", ""), 1) != 0 )
      {
         AV9sdt_sqs_parm.fromJSonString(AV10RawData, null);
         System.out.println( httpContext.getMessage( "&sdt_sqs_parm.records.Count ", "")+GXutil.trim( GXutil.str( AV9sdt_sqs_parm.getgxTv_Sdtsdt_sqs_parm_Records().size(), 9, 0)) );
         if ( AV9sdt_sqs_parm.getgxTv_Sdtsdt_sqs_parm_Records().size() == 0 )
         {
            AV13error = httpContext.getMessage( "Error de parámetros SQS: La colección \"records\" de la invocación está vacía", "") ;
            System.out.println( AV13error );
         }
         else
         {
            AV15i = (short)(1) ;
            while ( AV15i <= AV9sdt_sqs_parm.getgxTv_Sdtsdt_sqs_parm_Records().size() )
            {
               AV16cuerpos.add(((web.Sdtsdt_sqs_parm_recordsItem)AV9sdt_sqs_parm.getgxTv_Sdtsdt_sqs_parm_Records().elementAt(-1+AV15i)).getgxTv_Sdtsdt_sqs_parm_recordsItem_Body(), 0);
               AV15i = (short)(AV15i+1) ;
            }
         }
      }
      else
      {
         AV8sdt_eventBridge_parm.fromJSonString(AV10RawData, null);
         System.out.println( httpContext.getMessage( "&sdt_eventBridge_parm ", "")+AV8sdt_eventBridge_parm.toJSonString(false, true) );
         AV14body = AV8sdt_eventBridge_parm.getgxTv_Sdtsdt_eventBridge_parm_Detail() ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = parseawsparms.this.AV16cuerpos;
      this.aP2[0] = parseawsparms.this.AV13error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16cuerpos = new GXSimpleCollection<String>(String.class, "internal", "");
      AV13error = "" ;
      AV9sdt_sqs_parm = new web.Sdtsdt_sqs_parm(remoteHandle, context);
      AV8sdt_eventBridge_parm = new web.Sdtsdt_eventBridge_parm(remoteHandle, context);
      AV14body = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15i ;
   private short Gx_err ;
   private String AV10RawData ;
   private String AV14body ;
   private String AV13error ;
   private String[] aP2 ;
   private GXSimpleCollection<String>[] aP1 ;
   private GXSimpleCollection<String> AV16cuerpos ;
   private web.Sdtsdt_eventBridge_parm AV8sdt_eventBridge_parm ;
   private web.Sdtsdt_sqs_parm AV9sdt_sqs_parm ;
}

