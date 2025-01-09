package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_sqs_parm_recordsItem_attributes extends GxUserType
{
   public Sdtsdt_sqs_parm_recordsItem_attributes( )
   {
      this(  new ModelContext(Sdtsdt_sqs_parm_recordsItem_attributes.class));
   }

   public Sdtsdt_sqs_parm_recordsItem_attributes( ModelContext context )
   {
      super( context, "Sdtsdt_sqs_parm_recordsItem_attributes");
   }

   public Sdtsdt_sqs_parm_recordsItem_attributes( int remoteHandle ,
                                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_sqs_parm_recordsItem_attributes");
   }

   public Sdtsdt_sqs_parm_recordsItem_attributes( StructSdtsdt_sqs_parm_recordsItem_attributes struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "ApproximateReceiveCount") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SentTimestamp") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SenderId") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ApproximateFirstReceiveTimestamp") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdt_sqs_parm.recordsItem.attributes" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("ApproximateReceiveCount", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SentTimestamp", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SenderId", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ApproximateFirstReceiveTimestamp", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("ApproximateReceiveCount", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount, false, false);
      AddObjectProperty("SentTimestamp", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp, false, false);
      AddObjectProperty("SenderId", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid, false, false);
      AddObjectProperty("ApproximateFirstReceiveTimestamp", gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp, false, false);
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N = (byte)(1) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N ;
   }

   public web.Sdtsdt_sqs_parm_recordsItem_attributes Clone( )
   {
      return (web.Sdtsdt_sqs_parm_recordsItem_attributes)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_sqs_parm_recordsItem_attributes struct )
   {
      setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount(struct.getApproximatereceivecount());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp(struct.getSenttimestamp());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid(struct.getSenderid());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp(struct.getApproximatefirstreceivetimestamp());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_sqs_parm_recordsItem_attributes getStruct( )
   {
      web.StructSdtsdt_sqs_parm_recordsItem_attributes struct = new web.StructSdtsdt_sqs_parm_recordsItem_attributes ();
      struct.setApproximatereceivecount(getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount());
      struct.setSenttimestamp(getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp());
      struct.setSenderid(getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid());
      struct.setApproximatefirstreceivetimestamp(getgxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatereceivecount ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senttimestamp ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Senderid ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_attributes_Approximatefirstreceivetimestamp ;
}

