package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_sqs_parm_recordsItem extends GxUserType
{
   public Sdtsdt_sqs_parm_recordsItem( )
   {
      this(  new ModelContext(Sdtsdt_sqs_parm_recordsItem.class));
   }

   public Sdtsdt_sqs_parm_recordsItem( ModelContext context )
   {
      super( context, "Sdtsdt_sqs_parm_recordsItem");
   }

   public Sdtsdt_sqs_parm_recordsItem( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_sqs_parm_recordsItem");
   }

   public Sdtsdt_sqs_parm_recordsItem( StructSdtsdt_sqs_parm_recordsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "messageId") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "receiptHandle") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "body") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Body = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "md5OfBody") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "eventSourceArn") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "eventSource") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "awsRegion") )
            {
               gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "attributes") )
            {
               if ( gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes == null )
               {
                  gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes = new web.Sdtsdt_sqs_parm_recordsItem_attributes(remoteHandle, context);
               }
               GXSoapError = gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes.readxml(oReader, "attributes") ;
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
         sName = "sdt_sqs_parm.recordsItem" ;
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
      oWriter.writeElement("messageId", gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("receiptHandle", gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("body", gxTv_Sdtsdt_sqs_parm_recordsItem_Body);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("md5OfBody", gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("eventSourceArn", gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("eventSource", gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("awsRegion", gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes.writexml(oWriter, "attributes", sNameSpace1);
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
      AddObjectProperty("messageId", gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid, false, false);
      AddObjectProperty("receiptHandle", gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle, false, false);
      AddObjectProperty("body", gxTv_Sdtsdt_sqs_parm_recordsItem_Body, false, false);
      AddObjectProperty("md5OfBody", gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody, false, false);
      AddObjectProperty("eventSourceArn", gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn, false, false);
      AddObjectProperty("eventSource", gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource, false, false);
      AddObjectProperty("awsRegion", gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion, false, false);
      if ( gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes != null )
      {
         AddObjectProperty("attributes", gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes, false, false);
      }
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Messageid( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Messageid( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Body( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Body ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Body( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Body = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource = value ;
   }

   public String getgxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion( String value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion = value ;
   }

   public web.Sdtsdt_sqs_parm_recordsItem_attributes getgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes( )
   {
      if ( gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes == null )
      {
         gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes = new web.Sdtsdt_sqs_parm_recordsItem_attributes(remoteHandle, context);
      }
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes( web.Sdtsdt_sqs_parm_recordsItem_attributes value )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes = value;
   }

   public void setgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_SetNull( )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N = (byte)(1) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes = (web.Sdtsdt_sqs_parm_recordsItem_attributes)null;
   }

   public boolean getgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_IsNull( )
   {
      if ( gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_N = (byte)(1) ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Body = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion = "" ;
      gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_sqs_parm_recordsItem_N ;
   }

   public web.Sdtsdt_sqs_parm_recordsItem Clone( )
   {
      return (web.Sdtsdt_sqs_parm_recordsItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_sqs_parm_recordsItem struct )
   {
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Messageid(struct.getMessageid());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle(struct.getReceipthandle());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Body(struct.getBody());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody(struct.getMd5ofbody());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn(struct.getEventsourcearn());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource(struct.getEventsource());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion(struct.getAwsregion());
      setgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes(new web.Sdtsdt_sqs_parm_recordsItem_attributes(struct.getAttributes()));
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_sqs_parm_recordsItem getStruct( )
   {
      web.StructSdtsdt_sqs_parm_recordsItem struct = new web.StructSdtsdt_sqs_parm_recordsItem ();
      struct.setMessageid(getgxTv_Sdtsdt_sqs_parm_recordsItem_Messageid());
      struct.setReceipthandle(getgxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle());
      struct.setBody(getgxTv_Sdtsdt_sqs_parm_recordsItem_Body());
      struct.setMd5ofbody(getgxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody());
      struct.setEventsourcearn(getgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn());
      struct.setEventsource(getgxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource());
      struct.setAwsregion(getgxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion());
      struct.setAttributes(getgxTv_Sdtsdt_sqs_parm_recordsItem_Attributes().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_sqs_parm_recordsItem_N ;
   protected byte gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Messageid ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Receipthandle ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Body ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Md5ofbody ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsourcearn ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Eventsource ;
   protected String gxTv_Sdtsdt_sqs_parm_recordsItem_Awsregion ;
   protected web.Sdtsdt_sqs_parm_recordsItem_attributes gxTv_Sdtsdt_sqs_parm_recordsItem_Attributes=null ;
}

