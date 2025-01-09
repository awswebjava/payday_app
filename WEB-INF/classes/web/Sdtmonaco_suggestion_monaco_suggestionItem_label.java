package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtmonaco_suggestion_monaco_suggestionItem_label extends GxUserType
{
   public Sdtmonaco_suggestion_monaco_suggestionItem_label( )
   {
      this(  new ModelContext(Sdtmonaco_suggestion_monaco_suggestionItem_label.class));
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem_label( ModelContext context )
   {
      super( context, "Sdtmonaco_suggestion_monaco_suggestionItem_label");
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem_label( int remoteHandle ,
                                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtmonaco_suggestion_monaco_suggestionItem_label");
   }

   public Sdtmonaco_suggestion_monaco_suggestionItem_label( StructSdtmonaco_suggestion_monaco_suggestionItem_label struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "label") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "description") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "detail") )
            {
               gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail = oReader.getValue() ;
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
         sName = "monaco_suggestion.monaco_suggestionItem.label" ;
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
      oWriter.writeElement("label", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("description", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("detail", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail);
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
      AddObjectProperty("label", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label, false, false);
      AddObjectProperty("description", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description, false, false);
      AddObjectProperty("detail", gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail, false, false);
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description = value ;
   }

   public String getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail ;
   }

   public void setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail( String value )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_N = (byte)(0) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_N = (byte)(1) ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description = "" ;
      gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_N ;
   }

   public web.Sdtmonaco_suggestion_monaco_suggestionItem_label Clone( )
   {
      return (web.Sdtmonaco_suggestion_monaco_suggestionItem_label)(clone()) ;
   }

   public void setStruct( web.StructSdtmonaco_suggestion_monaco_suggestionItem_label struct )
   {
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label(struct.getLabel());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description(struct.getDescription());
      setgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail(struct.getDetail());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtmonaco_suggestion_monaco_suggestionItem_label getStruct( )
   {
      web.StructSdtmonaco_suggestion_monaco_suggestionItem_label struct = new web.StructSdtmonaco_suggestion_monaco_suggestionItem_label ();
      struct.setLabel(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label());
      struct.setDescription(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description());
      struct.setDetail(getgxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail());
      return struct ;
   }

   protected byte gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Label ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Description ;
   protected String gxTv_Sdtmonaco_suggestion_monaco_suggestionItem_label_Detail ;
}

