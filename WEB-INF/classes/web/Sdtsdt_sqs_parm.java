package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_sqs_parm extends GxUserType
{
   public Sdtsdt_sqs_parm( )
   {
      this(  new ModelContext(Sdtsdt_sqs_parm.class));
   }

   public Sdtsdt_sqs_parm( ModelContext context )
   {
      super( context, "Sdtsdt_sqs_parm");
   }

   public Sdtsdt_sqs_parm( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_sqs_parm");
   }

   public Sdtsdt_sqs_parm( StructSdtsdt_sqs_parm struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "records") )
            {
               if ( gxTv_Sdtsdt_sqs_parm_Records == null )
               {
                  gxTv_Sdtsdt_sqs_parm_Records = new GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem>(web.Sdtsdt_sqs_parm_recordsItem.class, "sdt_sqs_parm.recordsItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtsdt_sqs_parm_Records.readxmlcollection(oReader, "records", "recordsItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "records") )
               {
                  GXSoapError = oReader.read() ;
               }
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
         sName = "sdt_sqs_parm" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      if ( gxTv_Sdtsdt_sqs_parm_Records != null )
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
         gxTv_Sdtsdt_sqs_parm_Records.writexmlcollection(oWriter, "records", sNameSpace1, "recordsItem", sNameSpace1);
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
      if ( gxTv_Sdtsdt_sqs_parm_Records != null )
      {
         AddObjectProperty("records", gxTv_Sdtsdt_sqs_parm_Records, false, false);
      }
   }

   public GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem> getgxTv_Sdtsdt_sqs_parm_Records( )
   {
      if ( gxTv_Sdtsdt_sqs_parm_Records == null )
      {
         gxTv_Sdtsdt_sqs_parm_Records = new GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem>(web.Sdtsdt_sqs_parm_recordsItem.class, "sdt_sqs_parm.recordsItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtsdt_sqs_parm_Records_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_N = (byte)(0) ;
      return gxTv_Sdtsdt_sqs_parm_Records ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_Records( GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem> value )
   {
      gxTv_Sdtsdt_sqs_parm_Records_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_N = (byte)(0) ;
      gxTv_Sdtsdt_sqs_parm_Records = value ;
   }

   public void setgxTv_Sdtsdt_sqs_parm_Records_SetNull( )
   {
      gxTv_Sdtsdt_sqs_parm_Records_N = (byte)(1) ;
      gxTv_Sdtsdt_sqs_parm_Records = null ;
   }

   public boolean getgxTv_Sdtsdt_sqs_parm_Records_IsNull( )
   {
      if ( gxTv_Sdtsdt_sqs_parm_Records == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtsdt_sqs_parm_Records_N( )
   {
      return gxTv_Sdtsdt_sqs_parm_Records_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_sqs_parm_Records_N = (byte)(1) ;
      gxTv_Sdtsdt_sqs_parm_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_sqs_parm_N ;
   }

   public web.Sdtsdt_sqs_parm Clone( )
   {
      return (web.Sdtsdt_sqs_parm)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_sqs_parm struct )
   {
      GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem> gxTv_Sdtsdt_sqs_parm_Records_aux = new GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem>(web.Sdtsdt_sqs_parm_recordsItem.class, "sdt_sqs_parm.recordsItem", "PayDay", remoteHandle);
      Vector<web.StructSdtsdt_sqs_parm_recordsItem> gxTv_Sdtsdt_sqs_parm_Records_aux1 = struct.getRecords();
      if (gxTv_Sdtsdt_sqs_parm_Records_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtsdt_sqs_parm_Records_aux1.size(); i++)
         {
            gxTv_Sdtsdt_sqs_parm_Records_aux.add(new web.Sdtsdt_sqs_parm_recordsItem(gxTv_Sdtsdt_sqs_parm_Records_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtsdt_sqs_parm_Records(gxTv_Sdtsdt_sqs_parm_Records_aux);
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_sqs_parm getStruct( )
   {
      web.StructSdtsdt_sqs_parm struct = new web.StructSdtsdt_sqs_parm ();
      struct.setRecords(getgxTv_Sdtsdt_sqs_parm_Records().getStruct());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_sqs_parm_Records_N ;
   protected byte gxTv_Sdtsdt_sqs_parm_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem> gxTv_Sdtsdt_sqs_parm_Records_aux ;
   protected GXBaseCollection<web.Sdtsdt_sqs_parm_recordsItem> gxTv_Sdtsdt_sqs_parm_Records=null ;
}

