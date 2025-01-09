package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtarea_old extends GxUserType
{
   public Sdtarea_old( )
   {
      this(  new ModelContext(Sdtarea_old.class));
   }

   public Sdtarea_old( ModelContext context )
   {
      super( context, "Sdtarea_old");
   }

   public Sdtarea_old( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle, context, "Sdtarea_old");
   }

   public Sdtarea_old( StructSdtarea_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecDescrip") )
            {
               gxTv_Sdtarea_old_Secdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecHabilitada") )
            {
               gxTv_Sdtarea_old_Sechabilitada = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SecApoOpc") )
            {
               gxTv_Sdtarea_old_Secapoopc = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
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
         sName = "area_old" ;
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
      oWriter.writeElement("SecDescrip", gxTv_Sdtarea_old_Secdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecHabilitada", GXutil.booltostr( gxTv_Sdtarea_old_Sechabilitada));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SecApoOpc", GXutil.booltostr( gxTv_Sdtarea_old_Secapoopc));
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
      AddObjectProperty("SecDescrip", gxTv_Sdtarea_old_Secdescrip, false, false);
      AddObjectProperty("SecHabilitada", gxTv_Sdtarea_old_Sechabilitada, false, false);
      AddObjectProperty("SecApoOpc", gxTv_Sdtarea_old_Secapoopc, false, false);
   }

   public String getgxTv_Sdtarea_old_Secdescrip( )
   {
      return gxTv_Sdtarea_old_Secdescrip ;
   }

   public void setgxTv_Sdtarea_old_Secdescrip( String value )
   {
      gxTv_Sdtarea_old_N = (byte)(0) ;
      gxTv_Sdtarea_old_Secdescrip = value ;
   }

   public boolean getgxTv_Sdtarea_old_Sechabilitada( )
   {
      return gxTv_Sdtarea_old_Sechabilitada ;
   }

   public void setgxTv_Sdtarea_old_Sechabilitada( boolean value )
   {
      gxTv_Sdtarea_old_N = (byte)(0) ;
      gxTv_Sdtarea_old_Sechabilitada = value ;
   }

   public boolean getgxTv_Sdtarea_old_Secapoopc( )
   {
      return gxTv_Sdtarea_old_Secapoopc ;
   }

   public void setgxTv_Sdtarea_old_Secapoopc( boolean value )
   {
      gxTv_Sdtarea_old_N = (byte)(0) ;
      gxTv_Sdtarea_old_Secapoopc = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtarea_old_Secdescrip = "" ;
      gxTv_Sdtarea_old_N = (byte)(1) ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtarea_old_N ;
   }

   public web.Sdtarea_old Clone( )
   {
      return (web.Sdtarea_old)(clone()) ;
   }

   public void setStruct( web.StructSdtarea_old struct )
   {
      setgxTv_Sdtarea_old_Secdescrip(struct.getSecdescrip());
      setgxTv_Sdtarea_old_Sechabilitada(struct.getSechabilitada());
      setgxTv_Sdtarea_old_Secapoopc(struct.getSecapoopc());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtarea_old getStruct( )
   {
      web.StructSdtarea_old struct = new web.StructSdtarea_old ();
      struct.setSecdescrip(getgxTv_Sdtarea_old_Secdescrip());
      struct.setSechabilitada(getgxTv_Sdtarea_old_Sechabilitada());
      struct.setSecapoopc(getgxTv_Sdtarea_old_Secapoopc());
      return struct ;
   }

   protected byte gxTv_Sdtarea_old_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean gxTv_Sdtarea_old_Sechabilitada ;
   protected boolean gxTv_Sdtarea_old_Secapoopc ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtarea_old_Secdescrip ;
}

